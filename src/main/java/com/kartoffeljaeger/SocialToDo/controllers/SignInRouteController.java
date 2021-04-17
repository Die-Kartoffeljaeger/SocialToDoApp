package com.kartoffeljaeger.SocialToDo.controllers;

import javax.servlet.http.HttpServletRequest;

import com.kartoffeljaeger.SocialToDo.commands.users.UserSignInCommand;
import com.kartoffeljaeger.SocialToDo.controllers.enums.ViewNames;
import com.kartoffeljaeger.SocialToDo.models.api.UserSignIn;
import com.kartoffeljaeger.SocialToDo.models.repositories.ActiveUserRepository;
import com.kartoffeljaeger.SocialToDo.models.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/signIn")
public class SignInRouteController extends BaseRouteController
{
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start()
	{
		return new ModelAndView(ViewNames.SIGN_IN.getViewName());
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView handleSignInRequest(HttpServletRequest request)
	{
		UserSignIn signIn =	new UserSignIn(
			request.getParameter("username"),
			request.getParameter("password"));

		UserSignInCommand signInCommand =
			new UserSignInCommand(signIn, request.getSession().getId());

		signInCommand.setUserRepository(userRepository);
		signInCommand.setActiveUserRepository(activeUserRepository);

		if(signInCommand.execute())
		{
			return new ModelAndView(
				REDIRECT_PREPEND.concat("/"));
		}
		
		return new ModelAndView();
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	ActiveUserRepository activeUserRepository;
}
