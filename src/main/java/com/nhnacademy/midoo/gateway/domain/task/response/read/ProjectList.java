package com.nhnacademy.midoo.gateway.domain.task.response.read;


import com.nhnacademy.midoo.gateway.domain.task.entity.Project;
import java.util.List;
import lombok.Data;

@Data
public class ProjectList {

    List<Project> projects;

    boolean hasNext;

    boolean hasPrevious;

    long currentPage;

}
