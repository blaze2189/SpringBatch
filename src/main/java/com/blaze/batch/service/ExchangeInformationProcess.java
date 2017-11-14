package com.blaze.batch.service;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.blaze.batch.entity.Fixer;
import com.blaze.batch.entity.LocalFix;

public interface ExchangeInformationProcess extends ItemProcessor<Fixer,List<LocalFix>> {
	
	

}
