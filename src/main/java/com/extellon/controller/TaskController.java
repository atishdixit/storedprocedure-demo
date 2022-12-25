package com.extellon.controller;

import com.extellon.domain.Name;
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
        return taskService.getTasks();
    }

    @GetMapping("/getTaskById/{id}")
    public TaskDto getTaskById(@PathVariable("id") int id){
        return taskService.getTask(id);
    }

    @GetMapping("/getTaskByName/{name}")
    public String getTaskByName(@PathVariable("name") String name){
        return taskRepository.getTaskByName(name).getName();
    }

    @Transactional
    @GetMapping("/getTaskByInOutParam/{id}")
    public String getTaskByName(@PathVariable("id") int id){
        return taskRepository.getByTaskId(id);
    }
}
