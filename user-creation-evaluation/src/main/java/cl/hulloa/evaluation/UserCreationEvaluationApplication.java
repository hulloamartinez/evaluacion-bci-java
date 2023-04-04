package cl.hulloa.evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("file:${APP_ENV}")
public class UserCreationEvaluationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCreationEvaluationApplication.class, args);
	}

}
