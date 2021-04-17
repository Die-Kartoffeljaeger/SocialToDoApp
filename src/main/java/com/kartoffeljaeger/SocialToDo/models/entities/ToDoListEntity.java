package com.kartoffeljaeger.SocialToDo.models.entities;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kartoffeljaeger.SocialToDo.models.api.ToDoList;

@Entity
@Table(name = "todolist")
public class ToDoListEntity {
    @Id
    @Column(name="entryid", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID entryId;

    public UUID getEntryId() {
        return this.entryId;
    }
    
    @Column(name = "userid")
    private UUID userId;

    public UUID getUserId() {
        return this.userId;
    }
    public ToDoListEntity setUserId(final UUID userId) {
        this.userId = userId;
        return this;
    }

    @Column(name = "createdon", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createdOn;

    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }
    
    @Column(name = "suggester")
    private String suggester;

    public String getSuggester() {
        return this.suggester;
    }
    public ToDoListEntity setSuggester(final String suggester) {
        this.suggester = suggester;
        return this;
    }

    @Column(name = "content")
    private String content;

    public String getContent() {
        return this.content;
    }
    public ToDoListEntity setContent(final String content) {
        this.content = content;
        return this;
    }

    @Column(name = "deadline")
    private LocalDateTime deadline;

    public LocalDateTime getDeadline() {
        return this.deadline;
    }
    public ToDoListEntity setDeadline(final LocalDateTime deadline) {
        this.deadline = deadline;
        return this;
    }
    
    public ToDoList synchronize(final ToDoList apiToDoList) {
        this.setSuggester(apiToDoList.getSuggester()); //Not certain these are arranged correctly...
        this.setContent(apiToDoList.getContent());
        
        apiToDoList.setEntryId(this.getEntryId());
        apiToDoList.setUserId(this.getUserId());

        return apiToDoList;
    }

    public ToDoListEntity() {
        this.entryId = new UUID(0,0);
        this.suggester = StringUtils.EMPTY;
        this.userId = new UUID(0,0);
        this.createdOn = LocalDateTime.now();
        this.content = StringUtils.EMPTY;
    }

    public ToDoListEntity(final ToDoList apiToDoList) {
        this.entryId = new UUID(0,0);
        this.userId = apiToDoList.getUserId();
        this.createdOn = LocalDateTime.parse(apiToDoList.getCreatedOn());
        this.suggester = apiToDoList.getSuggester();
        this.content = apiToDoList.getContent();

        //Might need to check for NULL on this one before trying to set it
        this.deadline = LocalDateTime.parse(apiToDoList.getDeadline());
        
    }
}
