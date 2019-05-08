package ar.uba.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackageClasses = DomainConfiguration.class)
public class DomainConfiguration {

}
