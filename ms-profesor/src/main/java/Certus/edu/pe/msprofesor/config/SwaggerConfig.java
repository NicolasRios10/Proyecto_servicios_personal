package Certus.edu.pe.msprofesor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.edu.certus.profesor"))
				.paths(PathSelectors.ant("/v1/**"))
				.build();
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Proyecto Microservicio_AA3")
				.description("")
				.version("1.0")
				.contact(new Contact("Nicolas Rios", "", "72674272@certus.edu.pe"))
				.license("")
				.licenseUrl("")
				.build();
	}
}
