package com.niya.taskservice.Service;

import com.niya.taskservice.DTO.TaskCreateRequest;
import com.niya.taskservice.DTO.TaskResponse;
import com.niya.taskservice.Model.Task;
import com.niya.taskservice.Repository.TaskRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Task> getTasks(Pageable pageable)
    {
        return taskRepository.findAll(pageable);
    }

    public Task getById(Long id) {

        return taskRepository.findById(id).orElseThrow(()->new RuntimeException("vhghgh"));
    }

    public void deleteByid(Long id) {

        taskRepository.deleteById(id);
    }
}
