package uz.todo.todo_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.todo.todo_list.dto.ToDoCreateDto;
import uz.todo.todo_list.entity.ToDoList;
import uz.todo.todo_list.repo.TodoRepo;
import uz.todo.todo_list.service.ToDoService;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    ToDoService toDoService;

    @PostMapping("/add")
    public ToDoList addTask(@RequestBody ToDoCreateDto dto) {
        return toDoService.addTask(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        toDoService.deleteTask(id);
    }

    @GetMapping("/updateStatus/{id}")
    public void updateStatusById(@PathVariable Long id) {
        toDoService.updateStatus(id);
    }

}
