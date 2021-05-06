package br.com.csptecnologia.agenda.configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/* Endereço de acesso a documentação  http://localhost:8080/swagger-ui.html */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket detalheApi() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.com.csptecnologia.agenda"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build());

		return docket;
	}

	private ApiInfoBuilder informacoesApi() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title("Agenda");
		apiInfoBuilder.description("Api para Agendamento de Pessoas");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso");
		apiInfoBuilder.license("Licença - Open Source");
		apiInfoBuilder.licenseUrl("jeandroac@gmail.com");
		apiInfoBuilder.contact(this.contato());

		return apiInfoBuilder;

	}
	private Contact contato() {

		return new Contact(
				"Jeandro Alves Correia",
				"(64) 9 9284-2200", 
				"jeandroac@gmail.com");
	}
}