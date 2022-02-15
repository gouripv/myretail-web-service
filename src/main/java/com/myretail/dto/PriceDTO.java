package com.myretail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents Price DTO which has the price and the currency of the
 * product.
 * 
 * @author Gouri
 *
 */
public class PriceDTO {

	private Float value;

	@JsonProperty("currency_code")
	private String currency;

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
