package com.blaze.batch.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blaze.batch.entity.LocalFix;
import com.blaze.batch.service.ExchangeInformationWriter;

@Service
public class ExchangeInformationWriterImpl implements ExchangeInformationWriter {

	@Override
	public void write(List<? extends List<LocalFix>> items) throws Exception {
		System.out.println(items.size());
		items.forEach(item -> {
			item.forEach(i -> {
				System.out.println(i.getCountryOrigin() + ":" + i.getCountryDestiny()+":"+i.getFixDate());
			});
		});
	}

	// @Override
	// public void write(List<? extends LocalFix> items) throws Exception {
	// items.forEach(item->{
	// System.out.println(item.getCountryOrigin()+":"+item.getCountryDestiny());
	// });
	// }

}
