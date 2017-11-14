package com.blaze.batch.job;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blaze.batch.entity.Fixer;
import com.blaze.batch.entity.LocalFix;
import com.blaze.batch.service.ExchangeInformationProcess;
import com.blaze.batch.service.ExchangeInformationReader;
import com.blaze.batch.service.ExchangeInformationWriter;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

	@Autowired
	protected JobBuilderFactory jobs;
	
	@Autowired
	protected StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	protected ExchangeInformationReader reader;
	
	@Autowired
	protected ExchangeInformationProcess process;
	
	@Autowired
	protected ExchangeInformationWriter writer;
	
	@Autowired
	protected JobExecutionListener listener;
	
	//tag::jobstep[]
	@Bean(name="addRegister")
	public Job addNewRegister() {
		return jobs.get("addNewRegister").listener(listener).start(step()).build();
	}
	
	@Bean
	public Step step() {
		System.out.println("la;sdjhfa;");
		Step step = stepBuilderFactory.get("step").<Fixer,List<LocalFix>>chunk(1).//number of lines to process before commit
				reader(reader).
				processor(process).
				writer(writer).
				build();
		return step;
	}
	
	@Bean 
	public ItemWriter<Integer> writer(){
		return null;
	}
	
	
}
