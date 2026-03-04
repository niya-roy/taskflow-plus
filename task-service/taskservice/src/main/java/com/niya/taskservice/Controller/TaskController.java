package com.niya.taskservice.Controller;

import com.niya.taskservice.DTO.TaskCreateRequest;
import com.niya.taskservice.DTO.TaskResponse;
import com.niya.taskservice.Model.Task;
import com.niya.taskservice.Service.TaskService;
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
    public TaskResponse createTask(@RequestBody TaskCreateRequest taskCreateRequest)
    {
        return  taskService.createTask(taskCreateRequest);
    }

    @GetMapping
    public List<Task> getAll()
    {
        return taskService.getTasks();
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
