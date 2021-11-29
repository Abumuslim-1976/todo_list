package uz.todo.todo_list.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.todo.todo_list.dto.ToDoCreateDto;
import uz.todo.todo_list.entity.ToDoList;
import uz.todo.todo_list.repo.TodoRepo;

import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService{

    @Autowired
    TodoRepo todoRepo;

    @Override
    public ToDoList addTask(ToDoCreateDto dto) {
        ToDoList toDoList = new ToDoList();
        toDoList.setName(dto.getName());
        toDoList.setDescription(dto.getDescription());
        todoRepo.save(toDoList);
        return toDoList;
    }

    @Override
    public void deleteTask(Long id) {
        try {
            todoRepo.deleteById(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(Long id) {
        Optional<ToDoList> listId = todoRepo.findById(id);
        ToDoList toDoList = listId.get();
        toDoList.setStatus(true);
    }
}
