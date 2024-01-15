package com.cydeo.service.impl;

import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks // injecting mocked userRepository
    UserServiceImpl userService;



    @Test
    void deleteByUserName() {
        // we want to test this method
        userService.deleteByUserName("hello@cydeo.com");

        // these methods never run, we are just mocking them
        verify(userRepository).findAll();
        verify(userRepository).deleteByUserName("hello@cydeo.com");


        verify(userRepository,times(2)).deleteByUserName("hello@cydeo.com"); // run it 2 times
        verify(userRepository,atLeast(5)).deleteByUserName("hello@cydeo.com");
        verify(userRepository,atLeastOnce()).deleteByUserName("hello@cydeo.com");
        verify(userRepository,atMostOnce()).deleteByUserName("hello@cydeo.com");
        verify(userRepository,atMost(5)).deleteByUserName("hello@cydeo.com");

        // run methods in order
        InOrder inOrder = inOrder(userRepository);

        inOrder.verify(userRepository).deleteByUserName("hello@cydeo.com");
        inOrder.verify(userRepository).findAll();

    }
}