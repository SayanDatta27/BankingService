package com.cg.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.cg.banking"})
@EntityScan(basePackages="com.cg.banking.beans")
@EnableJpaRepositories(basePackages="com.cg.banking.daoservices")

public class CgBankingPortalSpringBootMvcjpadataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgBankingPortalSpringBootMvcjpadataApplication.class, args);
	}

}
