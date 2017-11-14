package com.blaze.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@ComponentScan
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication springApp = new SpringApplication(App.class);
		springApp.setWebEnvironment(false);
//		ConfigurableApplicationContext context = springApp.run(args);
		 ApplicationContext context = springApp.run(args);
		// JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		System.out.println("job launched defined");
		// Job jobToDo = context.getBean("addRegister",Job.class);
		// try {
		// JobExecution je = jobLauncher.run(jobToDo, null);
		// while(je.getStatus().isRunning()) {
		// System.out.println("...");
		// }
		// } catch (JobExecutionAlreadyRunningException | JobRestartException |
		// JobInstanceAlreadyCompleteException
		// | JobParametersInvalidException e) {
		// e.printStackTrace();
		// }
		// System.out.println(context.getBeanDefinitionCount());
	}

}
