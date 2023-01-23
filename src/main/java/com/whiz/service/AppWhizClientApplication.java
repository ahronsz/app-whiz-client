package com.whiz.service;

import io.r2dbc.spi.ConnectionFactory;
import org.apache.commons.math3.distribution.GeometricDistribution;
import org.apache.commons.math3.random.RandomGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class AppWhizClientApplication {

	public static void main(String[] args) {
		/*
		Random gauss = new Random();
		List<Double> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Random gauss = new Random();
			Double resultado = gauss.nextGaussian() * 28.8661;
			resultado = Math.abs(resultado);
			list.add(resultado);
			Collections.sort(list);
		}
		list.forEach(aDouble -> {
			if (aDouble > 100) {
				System.out.println("error: " + aDouble);
			} else {
				System.out.println(aDouble);
			}
		});*/
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
