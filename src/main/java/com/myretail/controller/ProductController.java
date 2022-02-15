package com.myretail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.dto.ProductDTO;
import com.myretail.exception.ProductNotFoundException;
import com.myretail.manager.ProductManager;

/**
 * This is RESTFul service that provides API to get the product name and price.
 * It also provides API for changing the price and currency of a product.
 * 
 * @author Gouri
 *
 */
@RestController
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductManager productManager;

	/**
	 * This method is a HTTP GET method. to get the product details and price for a
	 * given id.
	 * 
	 * @param id is productId
	 * @return ProductDTO which has producName and price details
	 * @throws Exception Generic exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/v1/product/{id}")
	public ProductDTO getProductDetails(@PathVariable("id") Long id) throws Exception {

		if (id == null || id <= 0) {
			throw new IllegalArgumentException("The 'id' parameter must not be null or empty or <=0");
		}
		ProductDTO productDTO = productManager.getProductDetails(id);
		if (productDTO.getId() == null || productDTO.getId() == 0) {
			throw new ProductNotFoundException("ProductId:" + id + "is not found, Please check and try again!!");
		}
		return productManager.getProductDetails(id);

	}
	
	/**
	 * This method is a HTTP put method.
	 * update the price of the product for a given productId.
	 * @param id Id of the product to be updated.
	 * @param price Price to be updated.
	 * @return boolean Updated successfully or not.
	 * @throws Exception Generic exception.
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/v1/product/{id}")
	public boolean updateProductPrice(@PathVariable("id") Long productId, @RequestBody ProductDTO price) throws Exception{
		
		if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("The 'id' parameter must not be null or empty or <=0");
		}
		return productManager.updateProductPrice(productId, price.getPrice().getValue(),price.getPrice().getCurrency());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {

		ErrorResponse error = new ErrorResponse();
		if (ex instanceof IllegalArgumentException) {
			error.setErrorCode(HttpStatus.BAD_REQUEST.value());
			error.setMessage(ex.getMessage());
		} else if (ex instanceof ProductNotFoundException) {
			error.setErrorCode(HttpStatus.NOT_FOUND.value());
			error.setMessage(ex.getMessage());
		} else {
			error.setErrorCode(500);
			error.setMessage(" Unknown error occured. Contact support center");
		}
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.valueOf(error.getErrorCode()));
	}
}
