package com.example.demo.prj.service;

import com.example.demo.prj.entity.Todo;
import com.example.demo.prj.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository){

        this.todoRepository = todoRepository;
    }

    public Todo CreateTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo CreateTodo(long todoId,Todo todo){
        todo.setTodoId(todoId);

        return todoRepository.save(todo);
    }

    public List<Todo> findTodos(){
        return todoRepository.findAll();
    }

    public Todo findTodo(long todoId){
        return verifiedTodo(todoId);
    }

    public Todo verifiedTodo(long TODO_Id){
        Optional<Todo>optionalTodo=  todoRepository.findById(TODO_Id);
        Todo todo = optionalTodo.orElseThrow(()-> new NoSuchElementException());
        return todo;
    }

    public void deleteTodo(long todoId){
        todoRepository.deleteById(todoId);
    }

    public void deleteTodos(){
        todoRepository.deleteAll();
    }

    public Todo updateTodo(long todoId,Todo todo){
        Todo findTodo = findTodo(todoId);

        Optional.ofNullable(todo.getTitle()).ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(todo.getTodoOrder()).ifPresent(order -> findTodo.setTodoOrder(order));
        Optional.ofNullable(todo.getCompleted()).ifPresent(completed -> findTodo.setCompleted(completed));

        return findTodo(todoId);
    }

}
