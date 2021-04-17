package com.kartoffeljaeger.SocialToDo.controllers;

import javax.servlet.http.HttpServletRequest;

import com.kartoffeljaeger.SocialToDo.commands.users.UserRegisterCommand;
import com.kartoffeljaeger.SocialToDo.controllers.enums.ViewNames;
import com.kartoffeljaeger.SocialToDo.models.api.UserRegister;
import com.kartoffeljaeger.SocialToDo.models.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/register")
public class RegisterRouteController extends BaseRouteController
{
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start()
	{
		return new ModelAndView(ViewNames.REGISTER.getViewName());
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView handleRegisterRequest(HttpServletRequest request)
	{
		UserRegister register = new UserRegister(
			request.getParameter("username"),
			request.getParameter("password"));

		UserRegisterCommand registerCommand = new UserRegisterCommand(register);
		registerCommand.setUserRepository(this.userRepository);

		if (registerCommand.execute())
		{
			return new ModelAndView(
				REDIRECT_PREPEND.concat(ViewNames.SIGN_IN.getRoute()));
		}

		return new ModelAndView();
	}

	@Autowired
	UserRepository userRepository;
}
