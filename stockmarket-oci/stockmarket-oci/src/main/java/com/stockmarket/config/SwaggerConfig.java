package com.stockmarket.config;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.stockmarket.constant.Constants;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@EnableWebMvc
public class SwaggerConfig {	
	
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title(Constants.SWAGGER_TITLE)
	              .description(Constants.SWAGGER_DESCRIPTION)
	              .version(Constants.VERSION)
	              .license(new License().name(Constants.LICENSE).url(Constants.LICENSE_URL)))
	              .externalDocs(new ExternalDocumentation()
	              .description(StringUtils.EMPTY)
	              .url(Constants.TERMS_OF_SERVICE_URL));
	  }
}
