package com.fun.securty.server.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author IamMr
 * @date 2019年07月21日 —— 11:08
 */
public class SecurityEvent extends ApplicationEvent {
    public SecurityEvent() {
        super(null);
    }
}
