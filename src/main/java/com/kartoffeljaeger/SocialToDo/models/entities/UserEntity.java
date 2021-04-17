package com.kartoffeljaeger.SocialToDo.models.entities;

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
    private final UUID id = UUID.randomUUID(); //This probably needs to be different

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
    
    public UserEntity synchronize(final User apiUser) {
        this.setActive(apiUser.getActive());
        this.setUsername(apiUser.getUsername());

        return this;

    }
}
