package com.micah.todoApp.todo;

import java.time.LocalDate;
import java.util.List;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
//replacing the logic from serice to work with repository(db)
public class TodoControllerJPA {

    // autowiring the repository using constructor
    public TodoControllerJPA(TodoService todoService, TodoRepository repository) {
        super();
        this.todoRepository = repository;
        // this.todoService = todoService;
    }

    // replace the service(used to access static list data) with repository (access
    // data from db)
    // private TodoService todoService;
    private TodoRepository todoRepository;
   

    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public String listAllTodos(ModelMap model) {
        String username = getUsername();

        List<Todo> todos = todoRepository.findByUsername(username);
        // List<Todo> todos = todoService.findByUserName(username);

        model.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showCreateTodoPage(ModelMap model) {
        String username = getUsername();

        Todo todo = new Todo(0, username, "", LocalDate.now().plusDays(12), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String createTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        String username = getUsername();
        todo.setUsername(username);
        todoRepository.save(todo);

        // todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        // todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        // Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        String username = getUsername();
        todo.setUsername(username);
        todoRepository.save(todo);
        // todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName().toLowerCase();
    }
}
