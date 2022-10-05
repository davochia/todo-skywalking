package com.example.todo.service;

import com.example.todo.dto.TodoDto;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoImpl implements TodoI {

    Logger logger = LoggerFactory.getLogger(TodoImpl.class);

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto newTodo) {
        if (newTodo == null)
            throw new RuntimeException("Null data inserted");
        return TodoDto.getTodoDto(todoRepository.save(TodoDto.getTodo(newTodo)));
    }

    @Override
    public TodoDto findTodoById(Integer id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo == null)
            throw new RuntimeException("Todo with id: " + id + " is not found");

        return optionalTodo.map(TodoDto::getTodoDto).orElse(null);
    }

    @Override
    public List<TodoDto> getTodos() {
        List<Todo> todoList = todoRepository.findAll();

        List<TodoDto> todos = new ArrayList<TodoDto>();

        todoList.forEach(todo -> todos.add(TodoDto.getTodoDto(todo)));
        return todos;
    }

    @Override
    public TodoDto modifyTodo(Integer id, TodoDto newTodo) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo == null)
            throw new RuntimeException("Todo with id: " + id + " is not found");
        if (newTodo == null)
            throw new RuntimeException("Null data inserted");

        Todo todo = optionalTodo.get();

        todo.setTitle(newTodo.getTitle());
        todo.setReminder(newTodo.getReminder());
        todo.setDay(newTodo.getDay());
        todo.setDescription(newTodo.getDescription());
        return TodoDto.getTodoDto(todoRepository.save(todo));
    }

    @Override
    public void removeTodo(Integer id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo == null)
            throw new RuntimeException("Todo with id: " + id + " is not found");

        todoRepository.deleteById(id);
    }

    @Override
    public List<TodoDto> findTodoByTitle(String todoTitle) {
        List<TodoDto> todoList = getTodos();

        return todoList.stream().filter(t -> t.getTitle().equalsIgnoreCase(todoTitle)).collect(Collectors.toList());

    }
}
