package com.rizki.mufrizal.belajar.oauth2.mvc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rizki.mufrizal.belajar.oauth2.mvc.domain.User;
import com.rizki.mufrizal.belajar.oauth2.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by rizki on 05/02/15.
 */

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    private Gson gson = new GsonBuilder().create();

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUserList(){
        return userService.getUserList();
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public HashMap<String, Object> saveUser(@RequestBody String json){
        User user = gson.fromJson(json, User.class);
        userService.save(user);

        HashMap<String, Object> message = new HashMap<String, Object>();
        message.put("Success", "Data Tersimpan");
        
        return message;
    }
    
}
