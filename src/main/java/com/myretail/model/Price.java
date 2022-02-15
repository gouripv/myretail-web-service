package com.myretail.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

/**
 * This is DB object that contains price and currency of a product
 * 
 * @author Gouri
 *
 */
@Document
public class Price {

	@Id
	private String id;

	@Field
	private String currency;

	@Field
	private Float price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currency, id, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		return Objects.equals(currency, other.currency) && Objects.equals(id, other.id)
				&& Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", currency=" + currency + ", price=" + price + "]";
	}

}
