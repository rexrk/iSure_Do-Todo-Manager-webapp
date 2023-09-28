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

    public List<Todo> findByName(String name) {
        Predicate<? super Todo> predicate = todo -> todo.getName().equalsIgnoreCase(name);
        return todoList.stream().filter(predicate).toList();
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