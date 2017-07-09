package com.walmart.shopify.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.walmart.shopify.model.Seller;



@Repository
public class SellerSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Seller> searchSellers(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
						.orOperator(Criteria.where("shopName").regex(text, "i"), 
									Criteria.where("partnerId").regex(text, "i"),
									Criteria.where("sellerId").regex(text, "i"),
									Criteria.where("accessToken").regex(text, "i"), 
									Criteria.where("consumerId").regex(text, "i")
									)
						), Seller.class);
	}
	
}
