package com.example.reestructure.controllers;

import com.example.reestructure.models.entity.UserNew;
//import com.example.reestructure.models.service.HttpClient;
import com.example.reestructure.models.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping("/api")
public class UserReectructure {

    /** VARIABLES **/

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    /** METODOS **/

    @GetMapping("/users")
    public Object getUsers(){

        return userService.getUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<?> reestructurarData(){

        List<UserNew> listUserNew = null;

        // Mapa para almacenar objetos asociado a nombres y asignar mensajes de error
        Map<String, Object> response = new HashMap<>();

        try{
            listUserNew = userService.formatDataUser();

        }catch (Exception e){

            response.put("mensaje", "Error al realizar la consulta a la API USERS.");
            response.put("error", e.getMessage().concat(": ").concat(e.getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (listUserNew.size() == 0){
            response.put("mensaje", " La API USERS no contiene datos de usuario!");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        response.put("data", listUserNew);
        response.put("mensaje", "Data Reestructurada");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
