package com.equinix.xscale.common.service;

import com.equinix.xscale.common.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Boolean isProjectPresent(String projectName) {
        return projectRepository.findById(projectName).isPresent();
    }
}
