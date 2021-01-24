package com.javaspring.donateblood;

import com.javaspring.donateblood.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class DonatebloodApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonatebloodApplication.class, args);
	}

}
