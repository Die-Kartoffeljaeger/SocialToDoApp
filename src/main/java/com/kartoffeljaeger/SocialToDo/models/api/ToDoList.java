package com.kartoffeljaeger.SocialToDo.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ToDoList extends ApiResponse{
    private UUID entryId;
    private UUID userId;
    private String createdOn;
    private String suggester;
    private String content;
    private String deadline;

    //Entry ID is the uuid for each entry in the master table of to-do list entries
    public UUID getEntryId() {
        return this.entryId;
    }
    public ToDoList setEntryId(final UUID entryId) {
        this.entryId = entryId;
        return this;
    }

    //User ID is the uuid of the user that this entry belongs to (whoever's to-do list this entry goes on)
    public UUID getUserId() {
        return this.userId;
    }
    public ToDoList setUserId(final UUID userId) {
        this.userId = userId;
        return this;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }
    public ToDoList setCreatedOn(final String createdOn) {
        this.createdOn = createdOn;
        return this;
    }
    public ToDoList setCreatedOn(final LocalDateTime createdOn) {
        this.createdOn = createdOn.toString();
        return this;
    }

    //Suggester keeps track of who made the suggestion that is this entry. 
    public String getSuggester() {
        return this.suggester;
    }
    public ToDoList setSuggester(final String suggester) {
        this.suggester = suggester;
        return this;
    }

    //Content is the actual content of the suggestion. Whatever it is that the suggester wants the user to do.
    public String getContent() {
        return this.content;
    }
    public ToDoList setContent(final String content) {
        this.content = content;
        return this;
    }

    //Deadline is a sort of deadline to do that suggestion for this entry. This should be an optional component.
    public String getDeadline() {
        return this.deadline;
    }
    public ToDoList setDeadline(final String deadline) {
        this.deadline = deadline;
        return this;
    }
    public ToDoList setDeadline(final LocalDateTime deadline) {
        this.deadline = deadline.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return this;
    }

    public ToDoList() {
        super();

        this.entryId = new UUID(0,0);
        this.userId = new UUID(0,0);

        this.setCreatedOn(LocalDateTime.now());
    }

    public ToDoList(User suggestee, User suggester) { //These arguments might need to be ActiveUser instead of User
        super();

        this.entryId = new UUID(0,0);
        this.userId = suggestee.getId();
        this.suggester = suggester.getUsername();

        this.setCreatedOn(LocalDateTime.now());
    }

    public ToDoList(final ToDoListEntity toDoListEntity) {
        super(false);

        this.entryId = toDoListEntity.getEntryId();
        this.content = toDoListEntity.getContent();
        this.deadline = toDoListEntity.getDeadline();
        this.suggester = toDoListEntity.getSuggester();
        this.userId = toDoListEntity.getUserId();

        this.setCreatedOn(toDoListEntity.getCreatedOn());
    }
}
