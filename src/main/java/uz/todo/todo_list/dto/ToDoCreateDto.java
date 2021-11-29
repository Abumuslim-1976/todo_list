package uz.todo.todo_list.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoCreateDto {
    private String name;
    private String description;
}
