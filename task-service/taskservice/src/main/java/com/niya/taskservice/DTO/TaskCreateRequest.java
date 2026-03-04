package com.niya.taskservice.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskCreateRequest {

   @NotNull
    private String title;
    private String status;
}
