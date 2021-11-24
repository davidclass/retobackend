package com.example.reestructure.models.service;

import com.example.reestructure.models.entity.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository("userService")
public class UserServiceImpl implements IUserService {

    /**
     * VARIABLES
     **/
    private final RestTemplate restTemplate;

    @Value("${url.api}")
    private String url;


    /**
     * METODOS
     **/
    public UserServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
    }

    @Override
    public Object getUsers() {
        Object userOld = null;
        userOld = this.restTemplate.getForObject(url, Object.class);
        return userOld;
    }

    @Override
    public List<UserNew> formatDataUser() throws Exception {

        List<UserNew> listUserNew = new ArrayList<>();

        Data dataOld = null;
        UserNew userNew = null;

        try {
            dataOld = this.restTemplate.getForObject(url, Data.class);

            for (User userOld : dataOld.getData()) {

                userNew = new UserNew();

                userNew.setId(userOld.getId());
                userNew.setEmail(userOld.getEmail());
                userNew.setLast_name(userOld.getLast_name());

                listUserNew.add(userNew);

            }

        } catch (Exception e) {
            System.out.println("userOld_0: " + e.getMessage());
        }


        return listUserNew;
    }


}
