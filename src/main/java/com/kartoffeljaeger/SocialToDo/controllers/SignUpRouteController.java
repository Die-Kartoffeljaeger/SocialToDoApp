package com.kartoffeljaeger.SocialToDo.controllers;

import com.kartoffeljaeger.SocialToDo.controllers.enums.ViewNames;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/register")
public class SignUpRouteController extends BaseRouteController
{
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start()
	{
		return new ModelAndView(ViewNames.REGISTER.getViewName());
	}
}
