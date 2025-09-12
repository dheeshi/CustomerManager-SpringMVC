package net.codejava.customer.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;


@Configuration
@EnableJpaRepositories (basePackages = {"net.codejava.customer"})
public class JpaConfig {
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("salesdb");
		
		return factoryBean;
	}
	
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory enitityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(enitityManagerFactory);
		
		return transactionManager;
	}

}
