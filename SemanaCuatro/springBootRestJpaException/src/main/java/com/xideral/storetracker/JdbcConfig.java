package com.xideral.storetracker;

import javax.activation.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Inidicamos que es archivo de configuración ("Mundo Spring")
@Configuration
public class JdbcConfig {

	//https://howtodoinjava.com/spring-boot2/datasource-configuration/
    @Bean(name = "mySqlDataSource")
    @Primary
	public javax.sql.DataSource mySqlDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/web_store_tracker?useSSL=false&serverTimezone=UTC");
        dataSourceBuilder.username("springstudent");
        dataSourceBuilder.password("springstudent");
        return dataSourceBuilder.build();
    }
}
