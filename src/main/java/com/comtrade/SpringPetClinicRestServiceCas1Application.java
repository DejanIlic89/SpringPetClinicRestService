package com.comtrade;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@ComponentScan(basePackages={"com.comtrade"})
public class SpringPetClinicRestServiceCas1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringPetClinicRestServiceCas1Application.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.apis(RequestHandlerSelectors.basePackage("com.comtrade"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Pet Clinic API", 
				"Spring Boot Pet Clinic App", 
				"1.0", 
				"Free to use", 
				new springfox.documentation.service.Contact("Dejan Ilic", "http://localhost:8080", "theekey@gmail.com"), 
				"API License", 
				"http://localhost:8080",
				Collections.emptyList());
	}

}
