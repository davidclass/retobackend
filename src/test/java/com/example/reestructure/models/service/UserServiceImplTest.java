package com.example.reestructure.models.service;

import com.example.reestructure.models.entity.UserNew;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    private UserNew userNew;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userNew = new UserNew();
    }

    @Test
    void formatDataUser() throws Exception {
        assertNotNull(userService.formatDataUser());
    }
}