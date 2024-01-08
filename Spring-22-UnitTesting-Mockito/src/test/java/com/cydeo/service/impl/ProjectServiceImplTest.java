package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.enums.Status;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;
    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_test() {

        // given
        // preparation part for mock
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);
        when(projectMapper.convertToDto(project)).thenReturn(projectDTO);

        // when
        // where the execution happens
        ProjectDTO projectDTO1 = projectService.getByProjectCode(anyString());

        // then
        // verification for mock methods run or not
        verify(projectRepository).findByProjectCode(anyString());
        verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO1);

    }

    @Test
    void getByProjectCode_exception_test() {

        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project not found"));

        Throwable exception = assertThrows(RuntimeException.class, () -> projectService.getByProjectCode("as"));

        verify(projectRepository).findByProjectCode(anyString());

        assertEquals("Project not found", exception.getMessage());

    }

    @Test
    void save_test(){

        // given
        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();

        // mock how projectService.save() method works
        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        // when
        projectService.save(projectDTO);

        // then
        verify(projectMapper).convertToEntity(projectDTO);
        verify(projectRepository).save(project);

    }


}