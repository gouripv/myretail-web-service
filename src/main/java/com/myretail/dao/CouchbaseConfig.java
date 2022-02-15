package com.myretail.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

/**
 * CouchbaseConfiguration class. TODO: get host details from properties file and
 * password from env variables
 * 
 * @author Gouri
 *
 */
@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

	@Override
	public String getConnectionString() {
		return "couchbase://127.0.0.1";
	}

	@Override
	public String getUserName() {
		return "admin";
	}

	@Override
	public String getPassword() {
		return "admin123";
	}

	@Override
	public String getBucketName() {
		return "price";
	}

}
