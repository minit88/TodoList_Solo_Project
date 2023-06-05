package com.example.demo.prj.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "TODO")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TODO_ID")
    private long todoId;

    @Column(name="TITLE")
    private String title;

    @Column(name="TODO_ORDER")
    private int todoOrder;

    @Column(name="COMPLETED")
    private boolean completed;

    public boolean getCompleted(){
        return this.completed;
    }
}
