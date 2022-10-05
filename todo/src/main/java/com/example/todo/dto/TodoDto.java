package com.example.todo.dto;

import com.example.todo.model.Todo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoDto {

    private Integer id;
    private String title;
    private Boolean reminder;
    private LocalDateTime day;
    private String description;

    public static Todo getTodo(TodoDto todoDto){
        Todo todo  = new Todo();

        todo.setId(todoDto.getId());
        todo.setTitle(todoDto.getTitle());
        todo.setReminder(todoDto.getReminder());
        todo.setDay(todoDto.getDay());
        todo.setDescription(todoDto.getDescription());

        return todo;
    }

    public static TodoDto getTodoDto(Todo todo){
        TodoDto todoDto  = new TodoDto();

        todoDto.setId(todo.getId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setReminder(todo.getReminder());
        todoDto.setDay(todo.getDay());
        todoDto.setDescription(todo.getDescription());

        return todoDto;
    }
}
