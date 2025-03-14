package com.byui.studentstaffcommunication.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Post {
    @Id
    protected String id;
    protected String title;
    protected String content;
    protected String authorId;
    protected String parentId;
}
