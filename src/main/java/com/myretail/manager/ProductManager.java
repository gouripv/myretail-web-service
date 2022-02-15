package com.myretail.manager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myretail.dao.PriceRepository;
import com.myretail.dto.ProductDTO;
import com.myretail.model.Price;
import com.myretail.service.ProductService;

/**
 * This class is responsible for performing the business logic and data
 * integration.
 * 
 * @author Gouri
 *
 */
@Component
public class ProductManager {

	@Autowired
	private PriceRepository priceRepository;

	@Autowired
	private ProductService productService;

	public ProductDTO getProductDetails(Long productId) throws Exception {
		String productName = productService.getProductDetails(productId);
		Optional<Price> price = priceRepository.findById(String.valueOf(productId));
		return buildProductDTO(price.get(), productName);

	}

	public ProductDTO buildProductDTO(Price priceDO, String productName) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(Long.valueOf(priceDO.getId()));
		productDTO.setName(productName);
		productDTO.getPrice().setCurrency(priceDO.getCurrency());
		productDTO.getPrice().setValue(priceDO.getPrice());
		return productDTO;

	}

	public boolean updateProductPrice(Long productId, Float value, String currency) throws Exception {
		Price price = new Price();
		price.setId(String.valueOf(productId));
		price.setPrice(value);
		price.setCurrency(currency);
		priceRepository.save(price);
		return true;
	}

}
