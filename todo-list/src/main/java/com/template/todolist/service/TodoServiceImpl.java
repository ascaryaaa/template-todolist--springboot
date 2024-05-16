package com.template.todolist.service;

import com.template.todolist.model.TodoModel;
import com.template.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public TodoModel getTodoId(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public TodoModel saveTodoId(TodoModel todoModel) {
        return todoRepository.save(todoModel);
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public TodoModel updateTodoById(Long id, TodoModel todoModel) {
        Optional<TodoModel> existingTodo = todoRepository.findById(id);
        if (existingTodo.isPresent()) {
            TodoModel todoToUpdate = existingTodo.get();
            // Update fields with values from todoModel
            todoToUpdate.setTodo_name(todoModel.getTodo_name());
            // Save updated entity
            return todoRepository.save(todoToUpdate);
        } else {
            return null; // or throw an exception if preferred
        }
    }

    @Override
    public Object findAll() {
        return null;
    }
}
