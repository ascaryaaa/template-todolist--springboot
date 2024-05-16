package com.template.todolist.service;

import com.template.todolist.model.TodoModel;

public interface TodoService {
    TodoModel getTodoId(Long id);

    TodoModel saveTodoId(TodoModel todoModel);

    void deleteTodoById(Long id);

    TodoModel updateTodoById(Long id, TodoModel todoModel);

    Object findAll();
}
