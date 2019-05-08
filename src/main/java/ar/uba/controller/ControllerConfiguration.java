package ar.uba.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ar.uba.service.ServiceConfiguration;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = ControllerConfiguration.class)
@Import(ServiceConfiguration.class)
public class ControllerConfiguration {    
	
}
