 
package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MyObject;

@Repository
public interface MyObjectRepository extends MongoRepository<MyObject,String>{
	public MyObject findByKey(String key);
}