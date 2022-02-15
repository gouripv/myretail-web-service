package com.myretail.dao;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.myretail.model.Price;

/**
 * This is DAO layer to interact with the database to fetch price value and
 * currency from database and be able to update the values in DB
 * 
 * @author Gouri
 *
 */
@Repository
public interface PriceRepository extends CouchbaseRepository<Price, String> {

}
