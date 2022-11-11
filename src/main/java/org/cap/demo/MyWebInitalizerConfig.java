package org.cap.demo;

import java.util.concurrent.TimeUnit;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableTransactionManagement // Container managed Transactions
@EnableWebMvc
@Configuration
@ComponentScan("org.cap.demo")
public class MyWebInitalizerConfig implements WebMvcConfigurer{
	
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/images/")
			.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
		
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/")
		.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}


	@Bean
	public ViewResolver getViewResolverBean() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp"); // /WEB-INF/pages/greetpage.jsp
		
		//viewResolver.setViewClass(JstlView.class);
		return viewResolver;	
	}
	
	
	//EntityManagerFactory bean over Spring Context
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean entityManagerFactory= 
				new LocalEntityManagerFactoryBean();
		entityManagerFactory.setPersistenceUnitName("capg");
		
		return entityManagerFactory;
	}
	
	
	
	//Declarative Transactions bean over Spring Context
	@Bean
	public JpaTransactionManager getJpaTransactionManager() {
		JpaTransactionManager transactionManager=
				new JpaTransactionManager(getEntityManagerFactoryBean().getObject());
		
		return transactionManager;
	}

}
