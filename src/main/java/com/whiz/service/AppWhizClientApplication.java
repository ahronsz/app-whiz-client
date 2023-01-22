package com.whiz.service;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@SpringBootApplication
public class AppWhizClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppWhizClientApplication.class, args);
	}

	/*
	@Bean
	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		initializer.setDatabasePopulator(new CompositeDatabasePopulator(
				new ResourceDatabasePopulator(new ClassPathResource("schemaClient.sql")),
				new ResourceDatabasePopulator(new ClassPathResource("dataClient.sql"))
		));
		return initializer;
	}
	*/
}
