package com.cgi.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationSwaggerConfig {

	
	@Bean
	public Docket api() {
	
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cgi.main"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		// TODO Auto-generated method stub
		return new ApiInfo("SPRINGBOOT-WITH-SWAGGER-APPLICATION",
				"THIS  IS FIRST SWAGGER API APPLICATION",
				"Swagger 1.0v","http://localhost:9993/empsapp/home",
				new Contact("IMTIAZ-DEV", "http://localhost:9993/empsapp/home",
				"IMTIAZ@GMAIL.COM"), "Apache2.0", "https://apache.org/");
	}
}
