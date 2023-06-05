package com.example.demo.prj.dto;

import lombok.*;


@Data
public class TodoDto {
    private long todoId;
    private String title;
    private boolean completed;
    private int todoOrder;
}
