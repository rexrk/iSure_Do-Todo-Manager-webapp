package com.raman.springboottodoapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static final List<Todo> todoList = new ArrayList<>();
    private static int id = 0;
    static {
        todoList.add(new Todo(++id, "Raman", "Learn Spring Boot",
                LocalDate.now().plusYears(1), false));
        todoList.add(new Todo(++id, "Raman", "Learn Cloud native",
                LocalDate.now().plusYears(2), false));
        todoList.add(new Todo(++id, "Raman", "Learn DevOps",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> getTodos(String name) {
        return todoList;
    }

    public void addTodo(String name, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++id, name, description, targetDate, done);
        todoList.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todoList.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todoList.stream().filter(predicate).findFirst().get();

    }
    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todoList.add(todo); 
    }
}