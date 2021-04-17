package com.kartoffeljaeger.SocialToDo.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name="activeuser")
public class ActiveUserEntity {
    @Id
    @Column(name="id", updatable = false) 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;
    
    public UUID getId() {
        return this.id;
    }

    @Column(name = "userid")
    private UUID userId;

    public UUID getUserId() {
        return this.userId;
    }

    public ActiveUserEntity setUserId(final UUID userId) {
        this.userId = userId;
        return this;
    }

    @Column(name = "username")
    private String username;

    public String getUsername() {
        return this.username;
    }

    public ActiveUserEntity setUsername(final String username) {
        this.username = username;
        return this;
    }

    @Column(name = "sessionkey")
    private String sessionKey;

    public String getSessionKey() {
        return this.sessionKey;
    }

    public ActiveUserEntity setSessionKey(final String sessionKey) {
        this.sessionKey = sessionKey;
        return this;
    }

    @Column(name = "createdon", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createdOn;
    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }

    public ActiveUserEntity() {
        this.id = new UUID(0,0);
        this.username = StringUtils.EMPTY;
        this.userId = new UUID(0,0);
        this.sessionKey = StringUtils.EMPTY;
    }
    
}
