package com.kartoffeljaeger.SocialToDo.models.repositories;

import java.util.Optional;
import java.util.UUID;

import com.kartoffeljaeger.SocialToDo.models.entities.ActiveUserEntity;

import org.springframework.data.repository.CrudRepository;


public interface ActiveUserRepository extends CrudRepository<ActiveUserEntity, UUID>
{
	Optional<ActiveUserEntity> findById(UUID id);
	Optional<ActiveUserEntity> findBySessionKey(String sessionkey);
}
