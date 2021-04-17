package com.kartoffeljaeger.SocialToDo.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.kartoffeljaeger.SocialToDo.models.entities.UserEntity;

import org.apache.commons.lang3.StringUtils;

public class User extends ApiResponse {
    private UUID id;
    private String password;
    private String username;
    private boolean active;
    private String createdOn;

    private UUID getId() {
        return this.id;
    }
    public User setId(final UUID id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return this.username;
    }
    public User setUserName(final String username) {
        if (username.length() > 32) {
            //Do something to tell the user that the username can't be that long
            return this;
        }
        else {
            this.username = username;
            return this;
        }
    }

    public String getPassword() {
        return this.password;
    }
    public User setPassword(final String password) {
        this.password = password;
        return this;
    }

    public boolean getActive() {
        return this.active;
    }
    public User setActive(final boolean active) {
        this.active = active;
        return this;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }
    public User setCreatedOn(final String createdOn) {
        this.createdOn = createdOn;
        return this;
    }
    public User setCreatedOn(final LocalDateTime createdOn) {
        this.createdOn = 
            createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return this;
    }
    
    public User() {
        super();

        this.active = true;
        this.id = new UUID(0,0);
        this.password = StringUtils.EMPTY;
        this.username = StringUtils.EMPTY;

        this.setCreatedOn(LocalDateTime.now());

    }
    
    public User(final UserEntity userEntity) {
        super(false);

        this.active = userEntity.getActive();
        this.id = userEntity.getId();
        this.password = userEntity.getPassword().toString();
        this.username = userEntity.getUsername();

        this.setCreatedOn(userEntity.getCreatedOn());

    }
    
}
