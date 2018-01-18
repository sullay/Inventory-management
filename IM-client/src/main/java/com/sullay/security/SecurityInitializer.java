package com.sullay.security;

import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.sullay.session.Config;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	public SecurityInitializer() {
        super(SecurityConfig.class, Config.class);
	}
}
