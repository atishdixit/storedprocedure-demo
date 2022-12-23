package com.extellon.repository;

import com.extellon.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    //Approach 1 – Stored procedure as the method name
    @Procedure()
    public List<Task> taskList();

    //Approach 2 – Stored procedure name as a String value
    @Procedure("taskList")
    public List<Task> tasks();

    //Approach 3 – Stored procedure name as the procedureName attribute
    @Procedure(procedureName = "taskList")
    public List<Task> getTaskList();

    //Approach 4 – Stored procedure name as the value attribute
    @Procedure(value = "taskList")
    public List<Task> getTasks();
}
