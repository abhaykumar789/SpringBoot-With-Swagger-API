# SpringBoot-With-Swagger-API
---------------------------------------------------
- Swagger is a Specification for documenting REST API. It specifies the format i.e URL, method and representation to describe the REST web services.
- It provides tools to generate the documentation from the application code.
---------------------------------------------------------------
## The following are the steps involved to work with Swagger:
Step1: Add the following dependences:
    - springfox-swagger2
    - springfox-swagger-ui
    
Step2: Add the  following Configuration file
```
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

```

Step3: Start the  Application by using following URL:

 - http://localhost:9993/swagger-ui.html

Step4 : If you want to get JSON format data of api then use the following URL:
 - http://localhost:9993/v2/api-docs
---------------------------------------------------------------------------------------------------------------


