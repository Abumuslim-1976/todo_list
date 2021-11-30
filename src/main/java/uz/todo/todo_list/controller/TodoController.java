package uz.todo.todo_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.todo.todo_list.dto.ToDoCreateDto;
import uz.todo.todo_list.entity.ToDoList;
import uz.todo.todo_list.service.TodoService;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/add")
    public ToDoList addTask(@RequestBody ToDoCreateDto dto) {
        return todoService.addTask(dto);
    }

    @DeleteMapping("/{id}")
    public ToDoList deleteTask(@PathVariable Long id) {
        return todoService.deleteTask(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoList> getTask(@PathVariable Long id , ToDoCreateDto dto) {
        return ResponseEntity.ok(todoService.get(id));
    }

}
