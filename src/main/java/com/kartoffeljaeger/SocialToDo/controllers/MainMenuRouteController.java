package com.kartoffeljaeger.SocialToDo.controllers;

import javax.servlet.http.HttpServletRequest;

import com.kartoffeljaeger.SocialToDo.controllers.enums.ViewNames;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class MainMenuRouteController
{
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(final HttpServletRequest request)
	{
		// TODO: Use request to verify user is logged in (activeuser)

		return new ModelAndView(ViewNames.MAIN_MENU.getViewName());
	}
}
