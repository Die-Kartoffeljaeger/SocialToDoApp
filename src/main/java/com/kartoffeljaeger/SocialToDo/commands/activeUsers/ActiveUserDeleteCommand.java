package com.kartoffeljaeger.SocialToDo.commands.activeUsers;

import java.util.Optional;

import javax.transaction.Transactional;

import com.kartoffeljaeger.SocialToDo.models.entities.ActiveUserEntity;
import com.kartoffeljaeger.SocialToDo.models.repositories.ActiveUserRepository;

public class ActiveUserDeleteCommand
{
	private String sessionKey;
	private ActiveUserRepository activeUserRepository;
	
	public ActiveUserDeleteCommand(
		String sessionKey, ActiveUserRepository activeUserRepository)
	{
		this.sessionKey = sessionKey;
		this.activeUserRepository = activeUserRepository;
	}

	@Transactional
	public boolean execute()
	{
		if (activeUserRepository == null)
			return false;

		Optional<ActiveUserEntity> activeUserEntity =
			this.activeUserRepository.findBySessionKey(this.sessionKey);

		if (activeUserEntity.isEmpty())
			return false;

		this.activeUserRepository.delete(activeUserEntity.get());

		return true;
	}
}
