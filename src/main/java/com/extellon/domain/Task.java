package com.extellon.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "tasks", procedureName = "taskList", resultClasses = Task.class),
        @NamedStoredProcedureQuery(name = "getTask", procedureName = "task", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "tid", type = Integer.class) },
                resultClasses = Task.class)
        })
//Approach -1
public class Task {

    @Id
    private int id;
    private String name;
}
