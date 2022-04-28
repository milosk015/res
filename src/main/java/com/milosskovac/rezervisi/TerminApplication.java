package com.milosskovac.rezervisi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(scanBasePackages={"com.milosskovac.rezervisi.model"})
@EnableJpaRepositories(basePackages = "com.milosskovac.rezervisi.repository")
public class TerminApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerminApplication.class, args);
	}

}
