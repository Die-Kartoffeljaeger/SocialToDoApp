package com.kartoffeljaeger.SocialToDo.controllers;

import com.kartoffeljaeger.SocialToDo.controllers.enums.ViewNames;

import org.springframework.web.servlet.ModelAndView;

public class BaseRouteController extends BaseController
{
	protected static final String REDIRECT_PREPEND = "redirect:";

    protected ModelAndView invalidSessionResponse()
	{
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName(REDIRECT_PREPEND.concat(
			ViewNames.SIGN_IN.getRoute().concat(
				this.buildInitialQueryParameter("error", "101"))));

		return modelAndView;
	}
}
