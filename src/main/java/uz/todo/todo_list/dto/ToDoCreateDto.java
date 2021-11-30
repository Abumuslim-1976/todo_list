package uz.todo.todo_list.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ToDoCreateDto {
    @ApiModelProperty(required = true , example = "my first task")
    private String name;
    @ApiModelProperty(required = true , example = "this is my first task")
    private String description;
}
