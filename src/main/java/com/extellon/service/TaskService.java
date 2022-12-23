package com.extellon.service;

import com.extellon.domain.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getTasks();
    TaskDto getTask(int id);
}
