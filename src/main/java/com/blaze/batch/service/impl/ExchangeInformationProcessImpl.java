package com.blaze.batch.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.blaze.batch.entity.Fixer;
import com.blaze.batch.entity.LocalFix;
import com.blaze.batch.service.ExchangeInformationProcess;

@Service
public class ExchangeInformationProcessImpl implements ExchangeInformationProcess{

	@Override
	public List<LocalFix> process(Fixer fixer) throws Exception {
		List<LocalFix> returnResponse = new ArrayList<>();
		String countryBase = fixer.getCountryCode();
		Date date = fixer.getDate();		
		Map<String,Double> mapRates = fixer.getRates();
		for(Map.Entry<String,Double> value: mapRates.entrySet()) {
			String countryDestiny = value.getKey();
			Double fix = value.getValue();
			LocalFix localFix = new LocalFix();
			localFix.setCountryOrigin(countryBase);
			localFix.setCountryDestiny(countryDestiny);
			localFix.setFix(fix);
			localFix.setFixDate(date);
			returnResponse.add(localFix);
		}
		return returnResponse;
	}

}