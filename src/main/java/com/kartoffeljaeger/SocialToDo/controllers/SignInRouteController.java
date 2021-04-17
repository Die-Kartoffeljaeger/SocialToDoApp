package com.kartoffeljaeger.SocialToDo.controllers;

import javax.servlet.http.HttpServletRequest;

import com.kartoffeljaeger.SocialToDo.controllers.enums.ViewNames;

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
		return new ModelAndView();
	}
}
