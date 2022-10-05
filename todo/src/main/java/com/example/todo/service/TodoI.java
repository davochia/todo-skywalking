package com.example.todo.service;

import com.example.todo.dto.TodoDto;

import java.util.List;

public interface TodoI {
    TodoDto addTodo(TodoDto newTodo);
    TodoDto findTodoById(Integer id)  ;
    List<TodoDto> getTodos();
    TodoDto modifyTodo(Integer id, TodoDto newTodo);
    void removeTodo(Integer id)  ;
    List<TodoDto> findTodoByTitle(String todoTitle)  ;
}
