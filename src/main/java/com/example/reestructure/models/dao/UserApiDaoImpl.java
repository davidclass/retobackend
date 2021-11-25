package com.example.reestructure.models.dao;

import com.example.reestructure.models.entity.Data;
import com.example.reestructure.models.entity.UserNew;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository("dataDao")
public class UserApiDaoImpl implements IUserApiDao{

    /**
     * VARIABLES
     **/
    private final RestTemplate restTemplate;

    @Value("${url.api}")
    private String url;

    public UserApiDaoImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
    }

    @Override
    public Data consultarURL() {

        Data dataOld = null;
        dataOld = this.restTemplate.getForObject(url, Data.class);

        return dataOld;
    }

    @Override
    public Data consultarURL2() {

        Data dataOld = null;
        Object dataOld1;
        dataOld1 = this.restTemplate.getForObject(url, Object.class);
        System.out.println("consultarURL2: " + dataOld1);

        return dataOld;
    }


}
