package com.swacorp.mx.configuration;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "h2entityManagerFactory", basePackages = "com.swacorp.mx.dataproviders.database.persistance")
//@Profile("LOCAL")
public class H2DataSourceConfiguration {

	private static final String TCP_PORT_IL = "9092";
	private static final String TCP_PORT = "-tcpPort";
	private static final String TCP_ALLOW_OTHERS = "-tcpAllowOthers";
	private static final String TCP = "-tcp";

	private static final String WEB_PORT_MTX = "8082";
	private static final String WEB_PORT = "-webPort";
	private static final String WEB_ALLOW_OTHERS = "-webAllowOthers";
	private static final String WEB = "-web";

	@Value("classpath:sql/data.sql")
	private Resource script;

	
	@Bean("h2entityManagerFactory")
	@DependsOn("h2Server")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryLocal() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(integrationLayerDataSource());
		entityManager.setPackagesToScan("com.swacorp.mx.dataproviders.database.domain");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManager.setJpaVendorAdapter(vendorAdapter);
		entityManager.setJpaProperties(additionalProperties());

		return entityManager;
	}

	@Bean(name="integrationLayerDataSource")
	public DataSource integrationLayerDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost:9092/mem:spm;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
		//dataSource.set
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(@Qualifier("h2entityManagerFactory") EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer() {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(integrationLayerDataSource());
		//initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}

	private DatabasePopulator databasePopulator() {
		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(script);
		return populator;
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	@DependsOn("h2WebServer")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer(TCP, TCP_ALLOW_OTHERS, TCP_PORT, TCP_PORT_IL);
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2WebServer() throws SQLException {
		return Server.createWebServer(WEB, WEB_ALLOW_OTHERS,WEB_PORT, WEB_PORT_MTX);
	}

	
	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		properties.setProperty("hibernate.current_session_context_class", "thread");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "auto");
		return properties;

	}

}
