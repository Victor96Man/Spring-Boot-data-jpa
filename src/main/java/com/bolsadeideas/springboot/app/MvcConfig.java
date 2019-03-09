package com.bolsadeideas.springboot.app;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

/* Metodo para buscar la imagen dentro de una carpeta en el proyecto
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString(); 
		registry.addResourceHandler("/uploads/**")
		.addResourceLocations(resourcePath);
	}
*/
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error_403").setViewName("error_403");
	}

}
