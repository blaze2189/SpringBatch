package com.blaze.batch.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blaze.batch.entity.Fixer;
import com.blaze.batch.service.ExchangeInformationReader;
import com.blaze.batch.service.RESTExchange;

@Service
public class ExchangeInformationReaderImpl  implements ExchangeInformationReader{

	@Autowired
	private RESTExchange restExchange;
	
	private AtomicInteger atomicIndex = new AtomicInteger(0);
	private List<Fixer> listMap=null;
	
	@Override
	public Fixer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		Fixer returnMap = null;
		System.out.println("read");
		if(listMap==null) {
			System.out.println("create request");
			listMap=requestData();
		}
		
		if(atomicIndex.get()<listMap.size()) {
			System.out.println("get object");
			returnMap=listMap.get(atomicIndex.getAndIncrement());
		}
		System.out.println("return: "+returnMap);
		return returnMap;
	}

	@Override
	public List<Fixer> requestData() {
		List<Fixer> returnRequest = new ArrayList<>();
		returnRequest.add(restExchange.getFix());
		return returnRequest;
	}

}
