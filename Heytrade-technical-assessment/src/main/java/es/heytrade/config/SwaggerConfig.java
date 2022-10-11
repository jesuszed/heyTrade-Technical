package es.heytrade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

	static final String DETAIL_DESCRIPTION = "Technical assessment Pokedex for HeyTrade";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("moodle")
				.select()
				.apis(RequestHandlerSelectors.basePackage("es.heytrade.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfoMetaData());
	}

	private ApiInfo apiInfoMetaData() {

		return new ApiInfoBuilder().title("Pokedex API REST")
				.description("Technical assessment Pokedex for Heytrade - Jesús Rodríguez")
				.contact(new Contact("Dev-Team", "https://www.heytrade.es/", "jesus.zed@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("v1")
				.build();
	}
}
