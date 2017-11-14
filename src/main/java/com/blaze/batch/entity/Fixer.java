package com.blaze.batch.entity;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fixer {

	@JsonProperty("base")
	private String countryCode;
	@JsonProperty("date")
	private Date date;
	@JsonProperty("rates")
	private Map<String,Double> rates;
	
}