package com.fun.main.server;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author chenh
 * @date 2019-07-19
 */
@Configuration
@ComponentScan
@EnableJpaRepositories
@EntityScan
public class MainConfiguration {
}
