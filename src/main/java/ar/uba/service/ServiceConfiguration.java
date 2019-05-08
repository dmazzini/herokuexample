package ar.uba.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ar.uba.domain.DomainConfiguration;

@Configuration
@ComponentScan(basePackageClasses = ServiceConfiguration.class)
@EnableJpaRepositories
@Import(DomainConfiguration.class)
public class ServiceConfiguration {

}
