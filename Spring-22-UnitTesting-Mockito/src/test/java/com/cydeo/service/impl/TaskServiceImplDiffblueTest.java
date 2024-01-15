package com.cydeo.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Project;
import com.cydeo.entity.Role;
import com.cydeo.entity.Task;
import com.cydeo.entity.User;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import com.cydeo.repository.UserRepository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TaskServiceImpl.class})
@ExtendWith(SpringExtension.class)
class TaskServiceImplDiffblueTest {
    @MockBean
    private ProjectMapper projectMapper;

    @MockBean
    private TaskMapper taskMapper;

    @MockBean
    private TaskRepository taskRepository;

    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link TaskServiceImpl#findById(Long)}
     */
    @Test
    void testFindById() {
        // Arrange
        Role role = new Role();
        role.setDescription("The characteristics of someone or something");
        role.setId(1L);
        role.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role.setInsertUserId(1L);
        role.setIsDeleted(true);
        role.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role.setLastUpdateUserId(1L);

        User assignedEmployee = new User();
        assignedEmployee.setEnabled(true);
        assignedEmployee.setFirstName("Jane");
        assignedEmployee.setGender(Gender.MALE);
        assignedEmployee.setId(1L);
        assignedEmployee.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        assignedEmployee.setInsertUserId(1L);
        assignedEmployee.setIsDeleted(true);
        assignedEmployee.setLastName("Doe");
        assignedEmployee.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        assignedEmployee.setLastUpdateUserId(1L);
        assignedEmployee.setPassWord("Pass Word");
        assignedEmployee.setPhone("6625550144");
        assignedEmployee.setRole(role);
        assignedEmployee.setUserName("janedoe");

        Role role2 = new Role();
        role2.setDescription("The characteristics of someone or something");
        role2.setId(1L);
        role2.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role2.setInsertUserId(1L);
        role2.setIsDeleted(true);
        role2.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role2.setLastUpdateUserId(1L);

        User assignedManager = new User();
        assignedManager.setEnabled(true);
        assignedManager.setFirstName("Jane");
        assignedManager.setGender(Gender.MALE);
        assignedManager.setId(1L);
        assignedManager.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        assignedManager.setInsertUserId(1L);
        assignedManager.setIsDeleted(true);
        assignedManager.setLastName("Doe");
        assignedManager.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        assignedManager.setLastUpdateUserId(1L);
        assignedManager.setPassWord("Pass Word");
        assignedManager.setPhone("6625550144");
        assignedManager.setRole(role2);
        assignedManager.setUserName("janedoe");

        Project project = new Project();
        project.setAssignedManager(assignedManager);
        project.setEndDate(LocalDate.of(1970, 1, 1));
        project.setId(1L);
        project.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        project.setInsertUserId(1L);
        project.setIsDeleted(true);
        project.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        project.setLastUpdateUserId(1L);
        project.setProjectCode("Project Code");
        project.setProjectDetail("Project Detail");
        project.setProjectName("Project Name");
        project.setProjectStatus(Status.OPEN);
        project.setStartDate(LocalDate.of(1970, 1, 1));

        Task task = new Task();
        task.setAssignedDate(LocalDate.of(1970, 1, 1));
        task.setAssignedEmployee(assignedEmployee);
        task.setId(1L);
        task.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        task.setInsertUserId(1L);
        task.setIsDeleted(true);
        task.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        task.setLastUpdateUserId(1L);
        task.setProject(project);
        task.setTaskDetail("Task Detail");
        task.setTaskStatus(Status.OPEN);
        task.setTaskSubject("Hello from the Dreaming Spires");
        Optional<Task> ofResult = Optional.of(task);
        when(taskRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        TaskDTO taskDTO = new TaskDTO();
        when(taskMapper.convertToDTO(Mockito.<Task>any())).thenReturn(taskDTO);

        // Act
        TaskDTO actualFindByIdResult = taskServiceImpl.findById(1L);

        // Assert
        verify(taskMapper).convertToDTO(Mockito.<Task>any());
        verify(taskRepository).findById(Mockito.<Long>any());
        assertSame(taskDTO, actualFindByIdResult);
    }
}
