package com.org.realtimejavaapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket getDocket() {// http://localhost:8080/swagger-ui/index.html
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
	}


/*
 * @Bean public Docket getDocket() { return new
 * Docket(DocumentationType.SWAGGER_2).groupName("public-apis").apiInfo(
 * getApiInfo()) //
 * .select().apis(RequestHandlerSelectors.basePackage("com.org.java.Controllers"
 * )) .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.
 * class)).build(); }
 * 
 * public ApiInfo getApiInfo() { return new
 * ApiInfoBuilder().title("code-decode-apis").
 * description("api created by sreenu").version("1").build(); } }
 */