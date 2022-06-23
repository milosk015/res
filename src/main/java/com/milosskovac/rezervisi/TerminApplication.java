package com.milosskovac.rezervisi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(scanBasePackages={"com.milosskovac.rezervisi.model"})
@EnableJpaRepositories(basePackages = "com.milosskovac.rezervisi.repository")
public class TerminApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(TerminApplication.class, args);
	}

}
