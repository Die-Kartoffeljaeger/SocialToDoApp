package com.kartoffeljaeger.SocialToDo.commands.users;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import com.kartoffeljaeger.SocialToDo.models.api.UserSignIn;
import com.kartoffeljaeger.SocialToDo.models.entities.ActiveUserEntity;
import com.kartoffeljaeger.SocialToDo.models.entities.UserEntity;
import com.kartoffeljaeger.SocialToDo.models.repositories.ActiveUserRepository;
import com.kartoffeljaeger.SocialToDo.models.repositories.UserRepository;

import org.apache.commons.lang3.StringUtils;

public class UserSignInCommand
{
	private UserSignIn signIn;
	private String sessionKey;

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
			this.userRepository.findByUsername(this.signIn.getUsername());

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
		Optional<ActiveUserEntity> activeUserContainer =
			this.activeUserRepository.findById(user.get().getId());

		// If user is already logged in...
		if (activeUserContainer.isPresent())
		{
			// Updates session to current and then saves to database
			ActiveUserEntity activeUser =
				activeUserContainer.get().setSessionKey(sessionKey);

			this.activeUserRepository.save(activeUser);
		}
		else
		{
			// Make a new active user session in the database
			ActiveUserEntity activeUser = new ActiveUserEntity();
			activeUser.setUsername(user.get().getUsername());
			activeUser.setUserId(user.get().getId());
			activeUser.setSessionKey(sessionKey);

			this.activeUserRepository.save(activeUser);
		}

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

	UserRepository userRepository;
	public void setUserRepository(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	ActiveUserRepository activeUserRepository;
	public void setActiveUserRepository(ActiveUserRepository activeUserRepository)
	{
		this.activeUserRepository = activeUserRepository;
	}
}
