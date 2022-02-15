package com.myretail.service.beans;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is a service object that has product details.
 * 
 * @author Gouri
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductBean {

	private Data data;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Data {
		private Product product;

		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class Product {
			private String tcin;
			private Item item;

			@JsonIgnoreProperties(ignoreUnknown = true)
			public static class Item {
				@JsonProperty("product_description")
				private ProductDescription productDescription;

				@JsonIgnoreProperties(ignoreUnknown = true)
				public static class ProductDescription {
					private String title;

					public String getTitle() {
						return title;
					}

					public void setTitle(String title) {
						this.title = title;
					}

					@Override
					public int hashCode() {
						return Objects.hash(title);
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						ProductDescription other = (ProductDescription) obj;
						return Objects.equals(title, other.title);
					}

					@Override
					public String toString() {
						return "ProductDescription [title=" + title + "]";
					}

				}

				public ProductDescription getProductDescription() {
					return productDescription;
				}

				public void setProductDescription(ProductDescription productDescription) {
					this.productDescription = productDescription;
				}

				@Override
				public int hashCode() {
					return Objects.hash(productDescription);
				}

				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (obj == null)
						return false;
					if (getClass() != obj.getClass())
						return false;
					Item other = (Item) obj;
					return Objects.equals(productDescription, other.productDescription);
				}

				@Override
				public String toString() {
					return "Item [productDescription=" + productDescription + "]";
				}

			}

			public String getTcin() {
				return tcin;
			}

			public void setTcin(String tcin) {
				this.tcin = tcin;
			}

			public Item getItem() {
				return item;
			}

			public void setItem(Item item) {
				this.item = item;
			}

			@Override
			public int hashCode() {
				return Objects.hash(item, tcin);
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Product other = (Product) obj;
				return Objects.equals(item, other.item) && Objects.equals(tcin, other.tcin);
			}

			@Override
			public String toString() {
				return "Product [tcin=" + tcin + ", item=" + item + "]";
			}

		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		@Override
		public int hashCode() {
			return Objects.hash(product);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Data other = (Data) obj;
			return Objects.equals(product, other.product);
		}

		@Override
		public String toString() {
			return "Data [product=" + product + "]";
		}

	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductBean other = (ProductBean) obj;
		return Objects.equals(data, other.data);
	}

	@Override
	public String toString() {
		return "ProductBean [data=" + data + "]";
	}

}
