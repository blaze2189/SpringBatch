package com.blaze.batch.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalFix {

	@JsonProperty("codeBase")
	private String countryOrigin;
	@JsonProperty("countryRate")
	private String countryDestiny;
	@JsonProperty("fix")
	private Double fix;
	@JsonProperty("date")
	private Date fixDate;
}
