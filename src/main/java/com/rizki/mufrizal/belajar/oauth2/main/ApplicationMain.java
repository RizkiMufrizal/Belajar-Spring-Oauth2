package com.rizki.mufrizal.belajar.oauth2.main;

import com.rizki.mufrizal.belajar.oauth2.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by rizki on 03/02/15.
 */

@SpringBootApplication
public class ApplicationMain {
    
    public static void main(String[]args){
        SpringApplication.run(WebConfig.class);
    }
    
}
