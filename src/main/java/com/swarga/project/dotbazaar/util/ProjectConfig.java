package com.swarga.project.dotbazaar.util;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swarga.project.dotbazaar.entities.Category;
import com.swarga.project.dotbazaar.entities.Product;
import com.swarga.project.dotbazaar.entities.User;

@Configuration
@EnableTransactionManagement
public class ProjectConfig {

	@Bean("ds")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dotbazaardb?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("Swarga@1998");
		return dataSource;

	}
	@Bean("factoryBean")
	public LocalSessionFactoryBean getLocalSessionFactoryBean()
	{
		LocalSessionFactoryBean factoryBean= new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		Properties hibernateProperties= new Properties();
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		factoryBean.setHibernateProperties(hibernateProperties);
		factoryBean.setAnnotatedClasses(User.class,Category.class, Product.class);
		return factoryBean;
	}
	@Bean("hibernateTemplate")
	public HibernateTemplate getHibernateTemplate()
	{
		HibernateTemplate hibernateTemplate= new HibernateTemplate();
		//hibernateTemplate.setCheckWriteOperations(false);
		hibernateTemplate.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return hibernateTemplate;
	}
	@Bean("hibernateTransactionManager")
	public HibernateTransactionManager getHibernateTransactionManager()
	{
		HibernateTransactionManager hibernateTransactionManager= new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return hibernateTransactionManager;
	}
}
