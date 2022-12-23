package com.extellon.repository;

import com.extellon.domain.Task;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryApproach1 {

    @Autowired
    private EntityManager entityManager;

    public List<Task> taskList(){
        return entityManager.createNamedStoredProcedureQuery("tasks").getResultList();
    }

    public List<Task> getTask(int id){
        return entityManager.createNamedStoredProcedureQuery("getTask").setParameter("tid", id).getResultList();
    }
}
