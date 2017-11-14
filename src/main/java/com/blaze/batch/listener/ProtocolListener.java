package com.blaze.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Service;

@Service
public class ProtocolListener implements JobExecutionListener{

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("befor job");
		System.out.println("befor job");
		System.out.println("befor job");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("after job");
		System.out.println("after job");
		System.out.println("after job");
	}

}
