package es.heytrade.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	static final String detailDescription = "Technical assessment Pokedex for HeyTrade";

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("moodle")
				.select()
				.apis(RequestHandlerSelectors.basePackage("es.heytrade.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo(
			"Pokedex API REST",
			detailDescription,
			"1.0",
			"http://www.heytrade.es",
			new Contact("Heytrade", "https://www.heytrade.es", "contacto@heytrade.es"),
			"LICENSE",
			"LICENSE URL",
			Collections.emptyList());
	}
}
