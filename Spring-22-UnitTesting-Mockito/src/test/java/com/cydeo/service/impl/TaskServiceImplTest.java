package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskService;

    @Test
    void findById_bdd_test(){

        // given
        Task task = new Task();
        TaskDTO taskDTO = new TaskDTO();

        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDTO(task)).willReturn(taskDTO);

        // when
        TaskDTO returnedTaskDTO = taskService.findById(anyLong());

        // then
        then(taskRepository).should().findById(anyLong());
        then(taskRepository).should(never()).findById(-anyLong());
        then(taskMapper).should().convertToDTO(task);


        assertNotNull(returnedTaskDTO);



    }


}