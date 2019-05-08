package ar.uba.application;

import org.springframework.context.annotation.Configuration;

@Configuration
public interface DataInitializer {
	 void initializeData();
}
