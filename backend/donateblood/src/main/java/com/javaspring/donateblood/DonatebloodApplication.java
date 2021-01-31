package com.javaspring.donateblood;

import com.javaspring.donateblood.model.BloodType;
import com.javaspring.donateblood.model.User;
import com.javaspring.donateblood.repository.UserRepository;
import com.javaspring.donateblood.service.BloodTypeService;
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

	@Autowired
	private BloodTypeService bloodTypeService;
	private void seedBloodTypeTable() {
		List<BloodType> u = bloodTypeService.getBloodTypes();
		if(u == null || u.size() <= 0) {
			BloodType bloodTypeop = new BloodType();
			bloodTypeop.setName("0+");
			bloodTypeService.addBloodType(bloodTypeop);
			BloodType bloodType = new BloodType();
			bloodType.setName("0-");
			bloodTypeService.addBloodType(bloodType);
			bloodType.setName("A-");
			bloodTypeService.addBloodType(bloodType);
			bloodType.setName("A+");
			bloodTypeService.addBloodType(bloodType);
			bloodType.setName("B+");
			bloodTypeService.addBloodType(bloodType);
			bloodType.setName("B-");
			bloodTypeService.addBloodType(bloodType);
			bloodType.setName("AB-");
			bloodTypeService.addBloodType(bloodType);
			bloodType.setName("AB+");
			bloodTypeService.addBloodType(bloodType);

		}
	}
	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedBloodTypeTable();
		seedUsersTable();
	}


	public static void main(String[] args) {
		SpringApplication.run(DonatebloodApplication.class, args);
	}

}
