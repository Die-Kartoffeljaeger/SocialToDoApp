package com.kartoffeljaeger.SocialToDo.commands.users;

import javax.transaction.Transactional;

import com.kartoffeljaeger.SocialToDo.models.api.UserRegister;
import com.kartoffeljaeger.SocialToDo.models.entities.UserEntity;
import com.kartoffeljaeger.SocialToDo.models.repositories.UserRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRegisterCommand
{
	private UserRegister register;

	public UserRegisterCommand(UserRegister register)
	{
		this.register = register;
	}

	@Transactional
	public boolean execute()
	{
		if (!validateParams())
			return false;
		
		UserEntity user = new UserEntity();
		user.setActive(false);
		user.setUsername(this.register.getUsername());
		user.setPassword(this.register.getPassword().getBytes());

		this.userRepository.save(user);

		return true;
	}

	private boolean validateParams()
	{
		String username = this.register.getUsername();
		String password = this.register.getPassword();

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
}
