package com.kartoffeljaeger.SocialToDo.controllers;

import javax.servlet.http.HttpServletRequest;

import com.kartoffeljaeger.SocialToDo.controllers.enums.ViewNames;
import com.kartoffeljaeger.SocialToDo.models.repositories.ActiveUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class MainMenuRouteController extends BaseRouteController
{

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(final HttpServletRequest request)
	{
		// TODO: Use request to verify user is logged in (activeuser)
		if (activeUserRepository.findBySessionKey(request.getSession().getId()).isPresent()) {
			return new ModelAndView(ViewNames.MAIN_MENU.getViewName());
		}
		else {
			return this.invalidSessionResponse();
		}
	}

	@Autowired
	ActiveUserRepository activeUserRepository;
}
