package com.equinix.xscale.common.service;

import com.equinix.xscale.common.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Boolean isProjectPresent(String projectName) {
        return projectRepository.findById(projectName).isPresent();
    }
}
