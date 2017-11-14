package com.blaze.batch.service;

import java.util.List;

import org.springframework.batch.item.ItemReader;

import com.blaze.batch.entity.Fixer;

public interface ExchangeInformationReader  extends ItemReader<Fixer>{
	
	List<Fixer> requestData();
	
}
