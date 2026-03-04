package com.niya.taskservice.DTO;

import lombok.Data;

@Data
public class TaskResponse {

    Long id;
    String title;
    String status;
}
