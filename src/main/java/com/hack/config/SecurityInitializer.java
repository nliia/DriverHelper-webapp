package com.hack.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author lnurullina
 */
@Order(2)
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}