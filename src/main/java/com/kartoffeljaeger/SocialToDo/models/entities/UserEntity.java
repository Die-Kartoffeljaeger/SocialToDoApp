package com.kartoffeljaeger.SocialToDo.models.entities;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Indexed;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kartoffeljaeger.SocialToDo.models.api.User;

@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @Column(name="id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;

    public UUID getId() {
        return this.id;
    }

    @Column(name = "username")
    private String username;

    public String getUsername() {
        return this.username;
    }

    public UserEntity setUsername(final String username) {
        this.username = username;
        return this;
    } 

    @Column(name = "password")
    private byte[] password;

    public byte[] getPassword() {
        return this.password;
    }

    public UserEntity setPassword(final byte[] password) {
        this.password = password;
        return this;
    }

    @Column(name = "active")
    private boolean active;

    public boolean getActive() {
        return this.active;
    }

    public UserEntity setActive(final boolean active) {
        this.active = active;
        return this;
    }

    @Column(name = "createdon", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createdOn;

    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }
    
    public User synchronize(final User apiUser) {
        this.setActive(apiUser.getActive());
        this.setUsername(apiUser.getUsername());
        if (!StringUtils.isBlank(apiUser.getPassword())) {
            this.setPassword(apiUser.getPassword().getBytes());
        }

        apiUser.setId(this.getId());
        apiUser.setCreatedOn(this.getCreatedOn());

        return apiUser;

    }

    public UserEntity() {
        this.active = false;
        this.id = new UUID(0,0);
        this.password = new byte[0];
        this.username = new String();
        this.createdOn = LocalDateTime.now();
    }

    public UserEntity(final User apiUser) {
        this.id = new UUID(0,0);
        this.active = apiUser.getActive();
        this.createdOn = LocalDateTime.parse(apiUser.getCreatedOn());
        this.password = apiUser.getPassword().getBytes();

    }
}
