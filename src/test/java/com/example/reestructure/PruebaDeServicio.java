package com.example.reestructure;


import com.example.reestructure.models.entity.UserNew;
import com.example.reestructure.models.service.IUserService;
import com.example.reestructure.models.service.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaDeServicio {

    @Autowired
    UserServiceImpl userService;

    @Before
    public void antesDeCadaPrueba(){
        System.out.println("antesDeCadaPrueba");

    }

    @Test
    public void pruebaDeFormatDataUser() throws Exception {

        List<UserNew> userNewList = null;

        //Cuando
        userNewList = userService.formatDataUser();

        //Entonces ... verificamos
        assertTrue(userNewList.size() > 0);
//        assertEquals(6, userNewList.size());

    }

    @AfterAll
    public void despuesDeCadaPrueba(){
        System.out.println("despuesDeCadaPrueba");
    }
}
