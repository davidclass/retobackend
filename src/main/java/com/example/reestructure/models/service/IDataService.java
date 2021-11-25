package com.example.reestructure.models.service;

import com.example.reestructure.models.entity.UserNew;

import java.util.List;

public interface IDataService {
    public List<UserNew> formatDataUser() throws Exception;
}
