package com.template.todolist.controller;

import com.template.todolist.model.TodoModel;
import com.template.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/{id}")
    public ResponseEntity<TodoModel> getTodoById(@PathVariable Long id) {
        TodoModel todo = todoService.getTodoId(id);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TodoModel> createTodo(@RequestBody TodoModel todoModel) {
        TodoModel createdTodo = todoService.saveTodoId(todoModel);
        return ResponseEntity.ok(createdTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoModel> updateTodo(@PathVariable Long id, @RequestBody TodoModel todoModel) {
        TodoModel updatedTodo = todoService.updateTodoById(id, todoModel);
        if (updatedTodo != null) {
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TodoModel>> getAllTodos() {
        List<TodoModel> todos = (List<TodoModel>) todoService.findAll(); // Assuming a findAll method exists in TodoService
        return ResponseEntity.ok(todos);
    }
}
