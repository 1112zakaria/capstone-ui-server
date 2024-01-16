package leo.satellite.capstoneuiserver;

import leo.satellite.capstoneuiserver.dto.SignUpDto;
import leo.satellite.capstoneuiserver.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class CapstoneUiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneUiServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService) {
		return args -> {
			SignUpDto guestUser = new SignUpDto("guest", "guest", "guest", "guest".toCharArray());
			userService.register(guestUser);
		};
	}

}
