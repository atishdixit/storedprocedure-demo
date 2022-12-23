package com.extellon.controller;

import com.extellon.domain.Task;
import com.extellon.domain.TaskDto;
import com.extellon.repository.TaskRepository;
import com.extellon.service.TaskService;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/getALlTask")
    @Transactional
    public List<TaskDto> getALlTask(){

        List<Task> list = taskRepository.taskList();
        List<Task> list2 = taskRepository.tasks();
        List<Task> list3 = taskRepository.getTasks();
        List<Task> list4 = taskRepository.getTaskList();
        return taskService.getTasks();
    }

    @GetMapping("/getTaskById/{id}")
    public TaskDto getTaskById(@PathVariable("id") int id){
        return taskService.getTask(id);
    }
}
