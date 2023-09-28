package com.raman.springboottodoapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@SessionAttributes({"name"})
public class TodoControllerJpa {

    private final TodoRepository todoRepository;

    public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String name = getLoggedInUsername();
        model.addAttribute("todos",  todoRepository.findByName(name));
        return "todosList";
    }

    @GetMapping("add-todo")
    public String gotoAddTodoPage(ModelMap model) {
        String username = getLoggedInUsername();
        Todo todo = new Todo(0, username, "", LocalDate.now().plusDays(1), false);
        model.addAttribute("todo", todo);
        return "addTodo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "addTodo";
        }
        String username = getLoggedInUsername();
        todo.setName(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Optional<Todo> todo = todoRepository.findById(id);
        model.addAttribute("todo", todo);
        return "addTodo";
    }

    @PostMapping("update-todo")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "addTodo";
        }
        String username = getLoggedInUsername();
        todo.setName(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    private static String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}