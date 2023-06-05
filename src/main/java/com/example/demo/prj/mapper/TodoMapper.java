package com.example.demo.prj.mapper;

import com.example.demo.prj.dto.TodoDto;
import com.example.demo.prj.entity.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoDtoToTodo(TodoDto todoDto);

    TodoDto todoToTodoDto(Todo todo);
}
