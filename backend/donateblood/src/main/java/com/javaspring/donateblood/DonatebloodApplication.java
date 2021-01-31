package com.javaspring.donateblood;

import com.javaspring.donateblood.model.User;
import com.javaspring.donateblood.repository.UserRepository;
import com.javaspring.donateblood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class DonatebloodApplication {

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*").allowCredentials(false);
			}
		};
	}
	@Autowired
	private UserService userService;
	private void seedUsersTable() {
		List<User> u = userService.getUsers();
		if(u == null || u.size() <= 0) {
			User user = new User();
			user.setName("Spring Demo");
			user.setLastName("admin");
			user.setEmail("test@test.com");
			user.setPassword("pass");
			user.setUserName("demo");
			userService.addUser(user);
		}
	}
	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedUsersTable();
	}


	public static void main(String[] args) {
		SpringApplication.run(DonatebloodApplication.class, args);
	}

}
