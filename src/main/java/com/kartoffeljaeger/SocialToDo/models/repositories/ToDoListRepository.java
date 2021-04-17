package com.kartoffeljaeger.SocialToDo.models.repositories;

import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

import com.kartoffeljaeger.SocialToDo.models.entities.ToDoListEntity;

import org.springframework.data.repository.CrudRepository;

public interface ToDoListRepository extends CrudRepository<ToDoListEntity, UUID>{
    boolean existsById(UUID entryId);
    Optional<ToDoListEntity> findById(UUID entryId);
	Iterator<UUID> findAllByUserId(UUID userId);
}
