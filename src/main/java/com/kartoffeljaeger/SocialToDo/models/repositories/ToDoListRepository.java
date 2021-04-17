package com.kartoffeljaeger.SocialToDo.models.repositories;

<<<<<<< Updated upstream
=======
import java.util.Optional;
>>>>>>> Stashed changes
import java.util.UUID;

import com.kartoffeljaeger.SocialToDo.models.entities.ToDoListEntity;

import org.springframework.data.repository.CrudRepository;

public interface ToDoListRepository extends CrudRepository<ToDoListEntity, UUID>{
<<<<<<< Updated upstream
    
=======
    boolean existsById(UUID entryId);
    Optional<ToDoListEntity> findById(UUID entryId);
>>>>>>> Stashed changes
}
