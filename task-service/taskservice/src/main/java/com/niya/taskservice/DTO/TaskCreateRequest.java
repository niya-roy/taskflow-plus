package com.niya.taskservice.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskCreateRequest {

   @NotNull(message = "Title ids require")
    private String title;

    @NotNull(message = "Title ids require")
    private String status;
}
