package com.coolCompany.restCRUD;

import java.util.concurrent.Executor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync // enable use concurrent methods
public class RestCrudApplication  extends AsyncConfigurerSupport 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(RestCrudApplication.class, args);
	}

	//config for concurrent tasks
	@Override
  public Executor getAsyncExecutor() 
  {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(2);
    executor.setQueueCapacity(500);
    executor.setThreadNamePrefix("RestCrud-");
    executor.initialize();
    return executor;
  }

  @Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource messageSource() 
	{
		ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
		messageBundle.setBasename("classpath:messages/messages");
		messageBundle.setDefaultEncoding("UTF-8");
		return messageBundle;
	}
}
