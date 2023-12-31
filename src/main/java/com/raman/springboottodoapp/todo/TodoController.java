package com.raman.springboottodoapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

//@Controller
@SessionAttributes({"name"})
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) { this.todoService = todoService; }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername();
        model.addAttribute("todos",  todoService.findByName(username));
        return "todosList";
    }

    @GetMapping("add-todo")
    public String gotoAddNewTodoPage(ModelMap model) {
        String username = getLoggedInUsername();
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.addAttribute("todo", todo);
        return "addTodo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "addTodo";
        }
        String username = getLoggedInUsername();

        todoService.addTodo(username, todo.getDescription(), todo.getDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findById(id);
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
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private static String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}