package uz.todo.todo_list.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.todo.todo_list.entity.ToDoList;

public interface TodoRepo extends JpaRepository<ToDoList, Long> {

}
