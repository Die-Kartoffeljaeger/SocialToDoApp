package com.kartoffeljaeger.SocialToDo.models.api;

public class UserSignIn
{
	private String username;
	private String password;

	public UserSignIn(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getUsername()
	{
		return this.username;
	}

	public String getPassword()
	{
		return this.password;
	}
}
