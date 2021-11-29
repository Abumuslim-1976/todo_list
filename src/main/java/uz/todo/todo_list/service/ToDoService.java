package uz.todo.todo_list.service;

import uz.todo.todo_list.dto.ToDoCreateDto;
import uz.todo.todo_list.entity.ToDoList;

public interface ToDoService {

    ToDoList addTask(ToDoCreateDto dto);

    void deleteTask(Long id);

    void updateStatus(Long id);
}
