package com.kartoffeljaeger.SocialToDo.models.repositories;

import java.util.UUID;

import com.kartoffeljaeger.SocialToDo.models.entities.ToDoListEntity;

import org.springframework.data.repository.CrudRepository;

public interface ToDoListRepository extends CrudRepository<ToDoListEntity, UUID>{
    
}
