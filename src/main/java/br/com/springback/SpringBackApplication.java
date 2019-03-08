package br.com.springback;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBackApplication.class, args);
	}
	
}
