package com.rmishra.common.service;

import com.rmishra.common.entity.ProjectEntity;
import com.rmishra.common.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void testIsProjectPresent_WhenProjectExists_ReturnsTrue() {
        // Arrange
        String projectName = "test-project";
        when(projectRepository.findById(projectName)).thenReturn(Optional.of(new ProjectEntity()));

        // Act
        Boolean result = projectService.isProjectPresent(projectName);

        // Assert
        assertTrue(result);
    }
}

