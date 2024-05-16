package com.template.todolist.service;

import com.template.todolist.model.TodoModel;
import com.template.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
            todoToUpdate.setTodo_name(todoModel.getTodo_name());
            // Update other fields as needed
            return todoRepository.save(todoToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public List<TodoModel> findAll() {
        return todoRepository.findAll();
    }
}
