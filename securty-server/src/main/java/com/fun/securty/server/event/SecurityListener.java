package com.fun.securty.server.event;

import com.fun.securty.server.config.RbacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author IamMr
 * @date 2019年07月21日 —— 11:09
 */
@Configuration
public class SecurityListener implements ApplicationListener<SecurityEvent> {

    @Autowired
    private RbacService rbacService;

    @Override
    public void onApplicationEvent(SecurityEvent securityEvent) {

    }
}
