package com.example.todo.controller;

import com.example.todo.dto.TodoDto;
import com.example.todo.service.TodoImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/todos")
public class Todo {

    Logger logger = LoggerFactory.getLogger(Todo.class);

    @Autowired
    private TodoImpl todoService;

    @PostMapping
    @Operation(summary = "Add a new todo to system")
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto newTodo) {
        return new ResponseEntity<>(todoService.addTodo(newTodo), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all todos from system")
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return new ResponseEntity<>(todoService.getTodos(), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo Found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TodoDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Todo not found", content = @Content) })
    @Operation(summary = "Get todo from system find by id")
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodoById(
            @Parameter(description = "id of todo to be searched") @PathVariable Integer id) {
        return new ResponseEntity<>(todoService.findTodoById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit todo in the system")
    public ResponseEntity<TodoDto> editTodo(@PathVariable Integer id, @RequestBody TodoDto newTodo) {
        return new ResponseEntity<>(todoService.modifyTodo(id, newTodo), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete todo from system")
    public ResponseEntity<String> deleteTodo(@PathVariable Integer id) {
        todoService.removeTodo(id);
        return new ResponseEntity<>("Todo with ID: " + id + " deleted", HttpStatus.NO_CONTENT);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo Found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TodoDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid title supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Todo not found", content = @Content) })
    @Operation(summary = "Get todo from system find by title")
    @GetMapping("/todo/{title}")
    public ResponseEntity<List<TodoDto>> findByTitle(@RequestParam String title) {
        return new ResponseEntity<>(todoService.findTodoByTitle(title), HttpStatus.OK);
    }
}
