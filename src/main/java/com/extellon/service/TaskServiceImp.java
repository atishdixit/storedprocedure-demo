package com.extellon.service;

import com.extellon.domain.Task;
import com.extellon.repository.TaskRepositoryApproach1;
import com.extellon.domain.TaskDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskRepositoryApproach1 taskDao;
    @Override
    public List<TaskDto> getTasks() {
        taskDao.taskList().forEach(x->{
            Task task = (Task)x;
            System.out.println(task.getId());
            System.out.println(task.getName());

        });
        return taskDao.taskList().stream().map(task->new TaskDto(task.getId(), task.getName())).collect(Collectors.toList());
    }

    @Override
    public TaskDto getTask(int id) {
        Task task = taskDao.getTask(id).stream().findAny().orElse(new Task());
        System.out.println(task.getId());
        System.out.println(task.getName());
        return new TaskDto(task.getId(), task.getName());
    }
}
