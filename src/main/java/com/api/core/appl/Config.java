package com.api.core.appl;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource("file:/opt/appl-poi/")
@EnableJpaRepositories
public class Config {

}
