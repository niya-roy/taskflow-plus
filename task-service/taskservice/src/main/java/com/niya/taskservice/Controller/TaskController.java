package com.niya.taskservice.Controller;

import com.niya.taskservice.DTO.TaskCreateRequest;
import com.niya.taskservice.DTO.TaskResponse;
import com.niya.taskservice.Model.Task;
import com.niya.taskservice.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {



    private final TaskService taskService;

    public TaskController(TaskService taskService)
    {
        this.taskService=taskService;
    }

    @PostMapping
    public TaskResponse createTask(@Valid @RequestBody TaskCreateRequest taskCreateRequest)
    {
        return  taskService.createTask(taskCreateRequest);
    }

    @GetMapping
    public Page<Task> getAll(Pageable pageable)
    {

        return taskService.getTasks(pageable);
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id)
    {
        return taskService.getById(id);
    }

    @DeleteMapping("/{id}")


    public  void deletebyid(@PathVariable Long id)
    {
        taskService.deleteByid(id);
    }

}
