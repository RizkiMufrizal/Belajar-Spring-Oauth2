package com.rizki.mufrizal.belajar.oauth2.mvc.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rizki on 03/02/15.
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin page";
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String user() {
        return "user page";
    }

}
