package br.edu.infnet.appAgricola.model;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataConfiguration {
	
	   @Bean
	   @Primary
	   public DataSource dataSource() {
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	      dataSource.setUrl("jdbc:mysql://root:UDAmhzR0iTxf0OltZvJN@containers-us-west-12.railway.app:5459/railway");
	      dataSource.setUsername("root");
	      dataSource.setPassword("UDAmhzR0iTxf0OltZvJN");
	      return dataSource;
	   }

}
