package crudProject2.howToCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = "crudProject2")
@EnableJpaRepositories(basePackages = "crudProject2.v1.crudRepository")
@EntityScan(basePackages = "crudProject2.v1.crudRepository")
public class HowToCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowToCrudApplication.class, args);
	}

}
