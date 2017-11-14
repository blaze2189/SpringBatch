package com.blaze.batch.service;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.blaze.batch.entity.LocalFix;

public interface ExchangeInformationWriter extends  ItemWriter<List<LocalFix>> {

}
