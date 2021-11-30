package uz.todo.todo_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.todo.todo_list.dto.ToDoCreateDto;
import uz.todo.todo_list.entity.ToDoList;
import uz.todo.todo_list.repo.TodoRepo;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepo todoRepo;

    public ToDoList addTask(ToDoCreateDto dto) {
        ToDoList toDoList = new ToDoList();
        toDoList.setName(dto.getName());
        toDoList.setDescription(dto.getDescription());
        todoRepo.save(toDoList);
        return toDoList;
    }

    public ToDoList deleteTask(Long id) {
        todoRepo.deleteById(id);
        Optional<ToDoList> byId = todoRepo.findById(id);
        return byId.orElseGet(ToDoList::new);
    }


    public ToDoList get(Long id) {
        Optional<ToDoList> byId = todoRepo.findById(id);
        return byId.orElseGet(ToDoList::new);
    }
}
