package com.template.todolist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "todo_id", updatable = false, nullable = false)
    private Long todo_id;

    @Column(name = "todo_name")
    private String todo_name;
}
