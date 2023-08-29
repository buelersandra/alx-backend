package com.alx.infoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@SpringBootApplication
public class InfoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoMsApplication.class, args);
	}


}
