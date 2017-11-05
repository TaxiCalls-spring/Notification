package com.taxicalls.notification.configuration;

import java.util.logging.Logger;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan
@EntityScan("com.taxicalls.notification.model")
@EnableJpaRepositories("com.taxicalls.notification.repository")
@PropertySource("classpath:db-config.properties")
public class NotificationsConfiguration {

    protected Logger logger;

    public NotificationsConfiguration() {
        logger = Logger.getLogger(getClass().getName());
    }
}
