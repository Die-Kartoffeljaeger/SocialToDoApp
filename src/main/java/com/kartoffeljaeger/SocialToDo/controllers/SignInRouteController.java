package com.kartoffeljaeger.SocialToDo.controllers;

import org.springframework.data.convert.ReadingConverter;
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
		
	}
}
