package com.cooladata.dal.application;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cooladata.dal.application.interceptor.BaseEntityInterceptor;
import com.cooladata.dal.base.enums.application.PROFILE;
import com.mchange.v2.c3p0.ComboPooledDataSource;
@Configuration
@EnableJpaRepositories
public class DalBeanConfiguration {
	
	private final static Logger logger = LoggerFactory.getLogger(DalBeanConfiguration.class);



	public static Environment env;
	public static PROFILE profile ;
	public static String DAL_HOME;
	
	@Autowired
	SessionFactory sessionFactory;



	@PropertySources({@PropertySource("classpath:application_dev.properties")})
	public static class Local
	{
		@Autowired
		private Environment env;

//	    @Autowired
//	    EmbeddedWebApplicationContext server;

		@Bean(name="setEnv")
		public String aaa()
		{
			DalBeanConfiguration.profile = PROFILE.DEV;
			DalBeanConfiguration.env = env;

			return "aaa";
		}
	}



    @Bean
    public ViewResolver getViewResolver(){
    	
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".html");
        return resolver;
    }

	@Bean
	@DependsOn("setEnv")
	public DataSource dataSource() throws PropertyVetoException {

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(env.getProperty("spring.datasource.driverClassName"));
		dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUser(env.getProperty("spring.datasource.username"));
		String password = env.getProperty("spring.datasource.password");
		if (password != null)
		{
			dataSource.setPassword(password);
		}
     
		dataSource.setPreferredTestQuery(env.getProperty("spring.datasource.preferredTestQuery"));
        dataSource.setTestConnectionOnCheckin(true);
        dataSource.setTestConnectionOnCheckout(true);
        dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("spring.datasource.maxIdleTime")));
        dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("spring.datasource.minPoolSize")));
        dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("spring.datasource.maxPoolSize")));
        dataSource.setIdleConnectionTestPeriod(Integer.parseInt(env.getProperty("spring.datasource.idleConnectionTestPeriod")));
        dataSource.setAcquireIncrement(Integer.parseInt(env.getProperty("spring.datasource.acquireIncrement")));

       // dataSource.setConnectionCustomizerClassName("com.cooladata.common.ConnectionPoolLogger");

        
		return dataSource;
	}

	
      
   @Bean
   public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException, SQLException {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(dataSource());
      sessionFactory.setPackagesToScan(new String[] { "com.cooladata.dal.controller.project" });
      sessionFactory.setHibernateProperties(hibernateProperties());
      //sessionFactory.setNamingStrategy(ImprovedNamingStrategy.INSTANCE);
      Interceptor interceptor=  new BaseEntityInterceptor();
      sessionFactory.setEntityInterceptor(interceptor);
      

      return sessionFactory;
   }
   
     
   @Bean
   public OpenSessionInViewFilter openSessionInViewFilter()
   {
       final OpenSessionInViewFilter filter = new OpenSessionInViewFilter();
//       filter.s
//       filter.setSingleSession( true );
       return filter;
   }
   
 	   
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setPackagesToScan(new String[] { "com.cooladata.dal.controller.project" });
		return lef;
	}
	
//	 @Bean
//	 public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
//	        return entityManagerFactory.createEntityManager();
//	 }
	 
	
	@Bean
	@Primary
	public PlatformTransactionManager transactionManager() {
		//return new JpaTransactionManager();
		 HibernateTransactionManager txManager = new HibernateTransactionManager(sessionFactory);
		 txManager.setNestedTransactionAllowed(true);
  	     return txManager;
	}

  
   
   @Bean
   public RestTemplate restTemplate() {
	   
       return new RestTemplate(clientHttpRequestFactory());
   }
   


   private ClientHttpRequestFactory clientHttpRequestFactory() {
       HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
       factory.setReadTimeout(25000);
       factory.setConnectTimeout(2000);
       return factory;
   }

	
   @SuppressWarnings("serial")
   Properties hibernateProperties() {
	      return new Properties() {
	         {
	            setProperty("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
	            setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
	            setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
	            setProperty("hibernate.format_sql",env.getProperty("hibernate.format_sql"));
	            setProperty("hibernate.generate_statistics",env.getProperty("hibernate.generate_statistics"));
	            
//	            setProperty("hibernate.c3p0.min_size",env.getProperty("hibernate.c3p0.min_size"));
//	            setProperty("hibernate.c3p0.max_size",env.getProperty("hibernate.c3p0.max_size"));
//	            setProperty("hibernate.c3p0.max_statements",env.getProperty("hibernate.c3p0.max_statements"));
//	            setProperty("hibernate.c3p0.idle_test_period",env.getProperty("hibernate.c3p0.idle_test_period"));
	         }
	      };
	   }
}
