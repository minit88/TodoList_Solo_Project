package com.example.demo.prj.controller;

import com.example.demo.prj.dto.TodoDto;
import com.example.demo.prj.entity.Todo;
import com.example.demo.prj.mapper.TodoMapper;
import com.example.demo.prj.repository.TodoRepository;
import com.example.demo.prj.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    private final TodoService todoService;
    private final TodoMapper todoMapper;

    @Autowired
    public Controller(TodoService todoService,TodoMapper todoMapper){
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @PostMapping("/")
    public ResponseEntity postTodo(@RequestBody TodoDto todoDto){
        Todo todo = todoMapper.todoDtoToTodo(todoDto);
        TodoDto response = todoMapper.todoToTodoDto(todoService.CreateTodo(todo));
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity getTodos(){
        List<TodoDto> todos = new ArrayList<>();
        for(Todo element : todoService.findTodos()){
            todos.add(todoMapper.todoToTodoDto(element));
        }

        return new ResponseEntity(todos,HttpStatus.OK);
    }


    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") long todoId){
        Todo todo = todoService.findTodo(todoId);
        TodoDto response = todoMapper.todoToTodoDto(todo);

        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") long todoId,@RequestBody TodoDto todoDto){
        Todo todo = todoMapper.todoDtoToTodo(todoDto);
        todoService.CreateTodo(todoId,todo);
        TodoDto response = todoMapper.todoToTodoDto(todoService.findTodo(todoId));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/")
    public void deleteTodos(){
        todoService.deleteTodos();
    }

    @DeleteMapping("/{todo-id}")
    public void deleteTodo(@PathVariable("todo-id") long todoId){
        todoService.deleteTodo(todoId);
    }
}
