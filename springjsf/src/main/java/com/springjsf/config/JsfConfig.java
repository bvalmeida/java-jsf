package com.springjsf.config;

import jakarta.faces.webapp.FacesServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class JsfConfig {

    private static final Logger logger = LoggerFactory.getLogger(JsfConfig.class);

    @Bean
    public ServletRegistrationBean<FacesServlet> facesServletRegistration() {
        logger.info("Configuring FacesServlet");
        return new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
    }

}
