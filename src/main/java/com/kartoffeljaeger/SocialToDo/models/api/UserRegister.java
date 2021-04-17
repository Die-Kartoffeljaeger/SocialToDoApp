package com.kartoffeljaeger.SocialToDo.models.api;

public class UserRegister
{
	private String username;
	private String password;

	public UserRegister(String username, String password)
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
