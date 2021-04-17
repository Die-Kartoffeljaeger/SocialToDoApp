package com.kartoffeljaeger.SocialToDo.models.repositories;

import java.util.Optional;
import java.util.UUID;

import com.kartoffeljaeger.SocialToDo.models.entities.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, UUID>
{
	boolean existsById(UUID id);
	Optional<UserEntity> findById(UUID id);
	Optional<UserEntity> findByUsername(String username);
}
