package com.kartoffeljaeger.SocialToDo.controllers;

import javax.servlet.http.HttpServletRequest;

import com.kartoffeljaeger.SocialToDo.commands.activeUsers.ActiveUserDeleteCommand;
import com.kartoffeljaeger.SocialToDo.controllers.enums.ViewNames;
import com.kartoffeljaeger.SocialToDo.models.api.ApiResponse;
import com.kartoffeljaeger.SocialToDo.models.repositories.ActiveUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class SignInRestController
{
	@RequestMapping(value = "/signOut", method = RequestMethod.DELETE)
	public @ResponseBody ApiResponse signOut(final HttpServletRequest request)
	{
		ActiveUserDeleteCommand signOutCommand =
			new ActiveUserDeleteCommand(
				request.getSession().getId(),
				this.activeUserRepository);

		if (signOutCommand.execute())
		{
			return (new ApiResponse()).setRedirectUrl(ViewNames.SIGN_IN.getRoute());
		}
		else
			return new ApiResponse();
	}

	@Autowired
	ActiveUserRepository activeUserRepository;
}
