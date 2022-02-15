package com.myretail.exception;

/**
 * @author Gouri
 *
 */
public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = -73895375413396195L;

	public ProductNotFoundException(String message) {
		super(message);
	}

}
