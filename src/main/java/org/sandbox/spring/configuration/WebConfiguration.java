package org.sandbox.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
@EnableWebMvc
public class WebConfiguration {
	@Bean
	public ThymeleafViewResolver viewResolver(){
		ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
		thymeleafViewResolver.setTemplateEngine(getTemplate());
		thymeleafViewResolver.setOrder(1);
		return thymeleafViewResolver;
	}
	@Bean
	private SpringTemplateEngine getTemplate() {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(templateResolver());
		return springTemplateEngine;
	}
	
	@Bean
	private TemplateResolver templateResolver(){
		TemplateResolver templateResolver = new TemplateResolver();
		templateResolver.setPrefix("/WEB-INF/pages/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}
	
}
