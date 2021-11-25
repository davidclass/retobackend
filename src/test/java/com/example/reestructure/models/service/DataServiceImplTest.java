package com.example.reestructure.models.service;

import com.example.reestructure.models.dao.IUserApiDao;
import com.example.reestructure.models.entity.Data;
import com.example.reestructure.models.entity.Support;
import com.example.reestructure.models.entity.User;
import com.example.reestructure.models.entity.UserNew;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DataServiceImplTest {

    @Mock
    private IUserApiDao userApiDao;

    @Autowired
    private IDataService dataService;

    private UserNew userNew;

    private Data dataOld;
    private LinkedList<User> linkUser;
    private User user;
//    private Object support;
    private LinkedList<Support> linkSupport;
    private Support support;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        dataOld = new Data();
        dataOld.setPage(2);
        dataOld.setPer_page(5);
        dataOld.setTotal_pages(10);

        user = new User();
        user.setId(10);
        user.setEmail("davidclass2@gmail.com");
        user.setFirst_name("Juan");
        user.setLast_name("Perez");
        user.setAvatar("https://reqres.in/img/faces/1-image.jpg");

        linkUser = new LinkedList<>();
        linkUser.add(user);
        dataOld.setData(linkUser);

        support = new Support();
        support.setUrl("https://reqres.in/#support-heading");
        support.setText("To keep ReqRes free, contributions towards server costs are appreciated!");
        linkSupport = new LinkedList<>();
        linkSupport.add(support);

        dataOld.setSupport(linkSupport);

        userNew = new UserNew();
        userNew.setId(10);
        userNew.setEmail("davidclass2@gmail.com");
        userNew.setLast_name("Perez");
    }

    @Test
    void formatDataUser() throws Exception {
        when(userApiDao.consultarURL()).thenReturn(dataOld);

    }
}
