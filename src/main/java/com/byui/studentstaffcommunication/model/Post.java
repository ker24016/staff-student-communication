package com.byui.studentstaffcommunication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String title;
    protected String content;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    protected User author;
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    protected Post parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<Post> children;

    public Post(String title, String content, User author, Post parent, List<Post> children) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.parent = parent;
        this.children = children;
    }
}
