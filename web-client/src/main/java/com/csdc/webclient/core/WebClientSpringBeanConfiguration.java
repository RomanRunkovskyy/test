package com.csdc.webclient.core;

import com.csdc.automation.core.SpringBeanConfiguration;
import com.csdc.webclient.pageobjects.LoginPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClientSpringBeanConfiguration extends SpringBeanConfiguration {

    @Bean
    public LoginPage loginPage() {
        return new LoginPage();
    }
}
