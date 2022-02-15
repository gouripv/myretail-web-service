package com.myretail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is a business object that has product and its price details.
 * 
 * @author Gouri
 *
 */
public class ProductDTO {

	private Long id;
	private String name;
	
	@JsonProperty("current_price")
	private PriceDTO price=new PriceDTO();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PriceDTO getPrice() {
		return price;
	}

	public void setPrice(PriceDTO price) {
		this.price = price;
	}
}
