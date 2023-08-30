package com.alx.infoms;

import com.alx.infoms.common.InfoExceptionHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(InfoExceptionHelper.class)
public class InfoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoMsApplication.class, args);
	}


}
