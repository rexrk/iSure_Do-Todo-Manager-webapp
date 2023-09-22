package com.raman.springboottodoapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static final List<Todo> todoList = new ArrayList<>();
    static {
        todoList.add(new Todo(1, "Raman", "Learn Spring Boot",
                LocalDate.now().plusYears(1), false));
        todoList.add(new Todo(2, "Raman", "Learn Cloud native",
                LocalDate.now().plusYears(2), false));
        todoList.add(new Todo(3, "Raman", "Learn DevOps",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> getTodos(String name) {
        return todoList;
    }
}