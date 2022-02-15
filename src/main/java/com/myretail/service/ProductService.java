package com.myretail.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myretail.service.beans.ProductBean;

/**
 * This class is responsible for performing a HTTP call to a external API.
 * 
 * @author Gouri
 *
 */
@Service
public class ProductService {

	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * This method performs a HTTP GET call to an external service and get product
	 * details in ProductBean object.
	 * 
	 * @param id
	 * @return productName which is fetched from external api
	 * @throws Exception
	 */
	public String getProductDetails(Long id) throws Exception {
		ProductBean productbean = restTemplate.getForObject(
				"https://redsky-uat.perf.target.com/redsky_aggregations/v1/redsky/case_study_v1?key=3yUxt7WltYG7MFKPp7uyELi1K40ad2ys&tcin="
						+ id,
				ProductBean.class);

		return productbean.getData().getProduct().getItem().getProductDescription().getTitle();
	}

}
