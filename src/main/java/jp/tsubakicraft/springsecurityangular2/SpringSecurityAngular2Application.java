package jp.tsubakicraft.springsecurityangular2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jp.tsubakicraft.springsecurityangular2.domain.User;
import jp.tsubakicraft.springsecurityangular2.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityAngular2Application {

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAngular2Application.class, args);
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Insert initial user");
			User user = userRepository.findByEmail("kazz12211@gmail.com");
			if(user == null) {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				user = new User();
				user.setEmail("kazz12211@gmail.com");
				user.setUsername("Kazuo Tsubaki");
				user.setPassword(passwordEncoder.encode("kt621221"));
				userRepository.save(user);
			}
			
        };
    }

}
