package com.wilkef.ecrack.setup.config;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Satya Sep 16, 2020
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	springfox.documentation.service.Parameter authHeader = new ParameterBuilder().parameterType("header")
			.name("Authorization").modelRef(new ModelRef("string")).build();

	@Bean
	public Docket createSwaggerDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo())
				.globalOperationParameters(Collections.singletonList(authHeader));
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Wilkef Application", "SAMPLE APP", "3.2GA", "https://wilkef.com/",
				new Contact("WILKEF", "https://www.wilkef.com/", "wilkef.com"), "Wilkef Licence",
				"https://www.wilkef.com/", new ArrayList<VendorExtension>());
	}
}
