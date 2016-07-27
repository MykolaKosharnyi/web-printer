package com.printmaster.nk.config;

import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*@EnableWebMvc
@Configuration
@ComponentScan({ "com.printmaster.nk.*" })
@EnableTransactionManagement
@Import({ SecurityConfig.class })
@ImportResource("classpath:/spring/appServlet/servlet-context.xml")*/
public class AppConfig/* extends WebMvcConfigurerAdapter*/{

	
	
	/*
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**")
	                        .addResourceLocations("/resources/");
		}
	
        @Bean
        public SessionFactory sessionFactory() {
                LocalSessionFactoryBuilder builder = 
			new LocalSessionFactoryBuilder(dataSource());
                builder.scanPackages("com.printmaster.nk.model")
                      .addProperties(getHibernateProperties());

                return builder.buildSessionFactory();
        }

	private Properties getHibernateProperties() {
                Properties prop = new Properties();
                prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                prop.put("hibernate.show_sql", "true");
                prop.put("hibernate.connection.Charset", "UTF-8");
                prop.put("hibernate.connection.CharacterEncoding", "UTF-8");
                prop.put("hibernate.connection.Useunicode", "true");
                prop.put("hibernate.hbm2ddl.auto", "update");
                return prop;
        }
	
	@Bean(name = "dataSource")
	public BasicDataSource dataSource() {
		
		BasicDataSource ds = new BasicDataSource();
		    ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/pmdatabase?characterEncoding=UTF-8");
			ds.setUsername("root");
			ds.setPassword("");
		return ds;
	}
	
	//Create a transaction manager
	@Bean
        public HibernateTransactionManager txManager() {
                return new HibernateTransactionManager(sessionFactory());
        }
		
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver 
                             = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	*/
}
