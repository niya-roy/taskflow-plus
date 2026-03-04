package com.niya.taskservice.Service;

import com.niya.taskservice.DTO.TaskCreateRequest;
import com.niya.taskservice.DTO.TaskResponse;
import com.niya.taskservice.Model.Task;
import com.niya.taskservice.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    TaskService(TaskRepository taskRepository)
    {
        this.taskRepository=taskRepository;
    }

    public TaskResponse createTask(TaskCreateRequest taskCreateRequest)
    {
        Task task=new Task();
        task.setTitle(taskCreateRequest.getTitle());
        task.setStatus(taskCreateRequest.getStatus());

        Task saved=taskRepository.save(task);

        TaskResponse taskResponse=new TaskResponse();
        taskResponse.setId(saved.getId());
        taskResponse.setStatus(saved.getStatus());
        taskResponse.setTitle(saved.getTitle());

        return taskResponse;
    }

    public List<Task> getTasks()
    {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(()->new RuntimeException("vhghgh"));
    }
}
