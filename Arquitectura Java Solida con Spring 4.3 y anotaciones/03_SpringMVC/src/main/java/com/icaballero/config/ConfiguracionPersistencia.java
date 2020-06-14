package com.icaballero.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ConfiguracionPersistencia {
	
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exeptionTranslation() {
		// Permite traduccir las excepciones de persistencia

		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		// Recoge el bean del entitymanager factori y asignar un gestor para el control
		// de las transacciones
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		// Este bean se encarga de registrar un entityManagerfactory

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		// Indicamos que usamos hibernate
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		em.setJpaVendorAdapter(vendorAdapter);

		// Mapeamos la unidad de persistencia
		em.setPersistenceUnitName("arquitectura");

		return em;

	}

}
