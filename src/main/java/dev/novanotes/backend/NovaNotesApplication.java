package dev.novanotes.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "dev.novanotes.backend.dao")
@EntityScan(basePackages = "dev.novanotes.backend.entity")
@EnableTransactionManagement
public class NovaNotesApplication {

//	set JAVA_HOME=C:\Program Files\Java\jdk-17
	public static void main(String[] args) {
		SpringApplication.run(NovaNotesApplication.class, args);
	}
}
