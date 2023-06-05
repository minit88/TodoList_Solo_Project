package com.example.demo.prj.repository;

import com.example.demo.prj.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    Todo save(Todo todo);



}
