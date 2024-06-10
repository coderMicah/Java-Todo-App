package com.micah.todoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private static List<Todo> todos= new ArrayList<>();

    static {
        todos.add(new Todo(1, "John Doe", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(1, "John Doe", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(1, "John Doe", "Learn FullStack Development", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUserName(String username){
        return todos;
    }

}
