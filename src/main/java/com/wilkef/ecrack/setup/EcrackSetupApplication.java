package com.wilkef.ecrack.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class EcrackSetupApplication {

	public static final Logger LOG = Logger.getLogger(EcrackSetupApplication.class.getName());

	@Value("${app.datasourece.url}")
	private String appDataSourceUrl;

	@Value("${app.datasourece.userName}")
	private String appDataSourceUserName;

	@Value("${app.datasourece.password}")
	private String appDataSourcePswd;

	@Value("${app.datasourece.driver.className}")
	private String appDataSourceDriverClassName;

	public static void main(String[] args) {
		
		SpringApplication.run(EcrackSetupApplication.class, args);
		try {
			LogManager.getLogManager().readConfiguration(new FileInputStream("myLogging.properties"));
			LOG.setLevel(Level.ALL);
			LOG.addHandler(new ConsoleHandler());
		} catch (SecurityException | IOException e) {
			LOG.log(Level.WARNING, "Interrupted!", e);
			    Thread.currentThread().interrupt();
		}
		LOG.info("Ecrack Application Started");
	}

	@Bean
	@Qualifier("appDatasource")
	public DataSource appDatasource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(appDataSourceUrl);
		dataSource.setUsername(appDataSourceUserName);
		dataSource.setPassword(appDataSourcePswd);
		dataSource.setDriverClassName(appDataSourceDriverClassName);
		dataSource.setMaxIdle(10);
		dataSource.setInitialSize(50);
		return dataSource;

	}

	@Bean
	@Qualifier("appJdbcTemplate")
	JdbcTemplate customerJdbcTempalte(@Qualifier("appDatasource") DataSource appDatasource) {
		return new JdbcTemplate(appDatasource);
	}

	@Bean
	public static PropertyPlaceholderConfigurer properties() {
		PropertyPlaceholderConfigurer propConfig = new PropertyPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[] { new ClassPathResource("application.properties") };
		propConfig.setLocations(resources);
		propConfig.setIgnoreUnresolvablePlaceholders(true);
		return propConfig;

	}

}
