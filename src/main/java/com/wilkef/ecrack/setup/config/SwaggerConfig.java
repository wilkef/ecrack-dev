package com.wilkef.ecrack.setup.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Satya
 *Sep 16, 2020
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createSwaggerDocket() 
	{
		return new Docket(DocumentationType.SWAGGER_2) 
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.wilkef.ecrack.setup.controller")) 
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Wilkef Application", "SAMPLE APP", "3.2GA", 
				"https://wilkef.com/",
				new Contact("WILKEF", "https://www.facebook.com/wilkef.com/",
						"wilkef.com"),
				"Wilkef Licence", "https://wilkef.com/", 
				new ArrayList<VendorExtension>());
	}
}
