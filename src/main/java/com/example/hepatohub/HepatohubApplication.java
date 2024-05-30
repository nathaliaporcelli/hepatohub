package com.example.hepatohub;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@SpringBootApplication
public class HepatohubApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
				.directory("./")
				.ignoreIfMalformed()
				.ignoreIfMissing()
				.load();

		String dbUsername = dotenv.get("DB_USERNAME");
		String dbPassword = dotenv.get("DB_PASSWORD");

		if (dbUsername != null) {
			System.setProperty("DB_USERNAME", dbUsername);
		}

		if (dbPassword != null) {
			System.setProperty("DB_PASSWORD", dbPassword);
		}

		SpringApplication.run(HepatohubApplication.class, args);
	}
}

