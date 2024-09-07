package com.praxis.cursos;

import javax.sql.DataSource;


import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.praxis.cursos") //define capeta de origenes de codigo
@PropertySource("classpath:database.properties")
public class AppConfig {
	

	@Autowired
	Environment environment;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(environment.getProperty("driver"));
		dmds.setUrl(environment.getProperty("url"));
		dmds.setUsername(environment.getProperty("dbuser"));
		dmds.setPassword(environment.getProperty("dbpassword"));
		return dmds;
	}

}
