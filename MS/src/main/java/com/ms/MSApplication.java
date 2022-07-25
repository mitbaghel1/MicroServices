package com.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {"com.ms.entity"})
@EnableJpaRepositories(basePackages = {"com.ms.repository"})
@SpringBootApplication(scanBasePackages= {"com.ms.*"})
public class MSApplication {
 public static void main(String[] args) {
	 SpringApplication.run(MSApplication.class, args);
 }
}
