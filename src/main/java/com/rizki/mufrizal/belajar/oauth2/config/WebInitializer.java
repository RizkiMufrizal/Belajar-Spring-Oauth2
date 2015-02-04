package com.rizki.mufrizal.belajar.oauth2.config;

import com.rizki.mufrizal.belajar.oauth2.main.ApplicationMain;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by rizki on 04/02/15.
 */

public class WebInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(ApplicationMain.class);
    }

}
