package com.kartoffeljaeger.SocialToDo.controllers.enums;

public enum ViewNames
{
	MAIN_MENU("mainMenu"),
	SIGN_IN("signIn");

	private String route;
	private String viewName;

	private ViewNames(final String viewName, final String route)
	{
		this.route = route;
		this.viewName = viewName;
	}

	private ViewNames(final String viewName)
	{
		this(viewName, "/".concat(viewName));
	}

	public String getRoute()
	{
		return this.route;
	}

	public String getViewName()
	{
		return this.viewName;
	}
}
