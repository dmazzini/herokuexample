package ar.uba.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import ar.uba.controller.ControllerConfiguration;

@SpringBootApplication
@Import(ControllerConfiguration.class)
public class Tp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp1Application.class, args);
	}
}
