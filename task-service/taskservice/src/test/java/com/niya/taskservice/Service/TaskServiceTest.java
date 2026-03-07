package com.niya.taskservice.Service;

import com.niya.taskservice.DTO.TaskCreateRequest;
import com.niya.taskservice.DTO.TaskResponse;
import com.niya.taskservice.Model.Task;
import com.niya.taskservice.Repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskService taskService;

    @Test
    void checkcreateTask()
    {
        TaskCreateRequest taskCreateRequest=new TaskCreateRequest();
        taskCreateRequest.setStatus("Open");
        taskCreateRequest.setTitle("The title");

        Task t=new Task();
        t.setId(1L);
        t.setStatus("Open");
        t.setTitle("The title");

        when(taskRepository.save(any(Task.class))).thenReturn(t);
        TaskResponse taskResponse=taskService.createTask(taskCreateRequest);

        assertNotNull(taskResponse);
        assertEquals(1L,taskResponse.getId());
        assertEquals("Open",taskResponse.getStatus());
        assertEquals("The title",taskResponse.getTitle());

        verify(taskRepository,times(1)).save(any(Task.class));
    }

    @Test
    void checkfindByid()
    {
        Task t=new Task();
        t.setId(1L);
        t.setTitle("The title");
        t.setStatus("Open");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(t));

        Task tr=taskService.getById(1L);

        assertNotNull(tr);
        assertEquals("The title",tr.getTitle());
        verify(taskRepository,times(1)).findById(1L);
    }

}
