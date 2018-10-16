package com.swacorp.mx.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatasourceConfiguration {

	//@Bean(name = "integrationLayerDataSource")
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost:9092/mem:acods;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
		return dataSource;
	}

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource datasource) {
        return new JdbcTemplate(datasource);
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
	
	
}
