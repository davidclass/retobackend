package com.example.reestructure.models.service;

import com.example.reestructure.models.dao.IUserApiDao;
import com.example.reestructure.models.entity.Data;
import com.example.reestructure.models.entity.User;
import com.example.reestructure.models.entity.UserNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Repository("dataService")
public class DataServiceImpl implements IDataService{

    @Autowired
    @Qualifier("dataDao")
    private IUserApiDao userApiDao;

    @Override
    public List<UserNew> formatDataUser() throws Exception {
        List<UserNew> listUserNew = new ArrayList<>();

        Data dataOld = null;
        UserNew userNew = null;

        try {
            dataOld = userApiDao.consultarURL();

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
