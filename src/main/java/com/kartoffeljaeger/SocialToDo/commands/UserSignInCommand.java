package com.kartoffeljaeger.SocialToDo.commands;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import com.kartoffeljaeger.SocialToDo.models.api.UserSignIn;
import com.kartoffeljaeger.SocialToDo.models.entities.UserEntity;
import com.kartoffeljaeger.SocialToDo.models.repositories.UserRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSignInCommand
{
	private UserSignIn signIn;
	private String sessionKey;

	@Autowired
	UserRepository userRepository;

	public UserSignInCommand(UserSignIn signIn, String sessionKey)
	{
		this.signIn = signIn;
		this.sessionKey = sessionKey;
	}

	@Transactional
	public boolean execute()
	{
		// Validate parameters
		if (!validateParams())
			return false;

		// Searches for user account by username
		Optional<UserEntity> user =
			userRepository.findByUsername(this.signIn.getUsername());

		// Checks if the user was found
		if (!user.isPresent())
			return false;

		// Checks if password used to sign in is correct
		if (!Arrays.equals(
				this.signIn.getPassword().getBytes(),
				user.get().getPassword()))
		{
			return false;
		}

		// -----
		// Sign in has been verified at this point, proceed to login
		// -----

		// Check to see if user is already logged in
		// TODO

		return true;
	}

	private boolean validateParams()
	{
		String username = this.signIn.getUsername();
		String password = this.signIn.getPassword();

		// Ensure username & password are not blank/null
		if (StringUtils.isBlank(username)
			|| username.length() > 32
			|| StringUtils.isBlank(password))
		{
			return false;
		}
		else
			return true;
	}
}
