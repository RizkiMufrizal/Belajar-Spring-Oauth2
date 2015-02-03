package com.rizki.mufrizal.belajar.oauth2.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by rizki on 03/02/15.
 */

@Configuration
@EntityScan(basePackages = {"com.rizki.mufrizal.belajar.oauth2.mvc.domain"})
@EnableAutoConfiguration
//@Import(WebSecurityConfig.class)
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.rizki.mufrizal.belajar.oauth2.mvc.repository"})
@ComponentScan(basePackages = {"com.rizki.mufrizal.belajar.oauth2"})
public class WebConfig {
}
