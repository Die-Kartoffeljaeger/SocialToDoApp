package com.kartoffeljaeger.SocialToDo.controllers.enums;

public enum QueryParamNames
{
	UNDEFINED(""),
	ERROR_CODE("errorCode");

	private String value;

	private QueryParamNames(final String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
}
