package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Map;
import com.example.demo.model.MyObject;
import com.example.demo.model.MyObject.pair;
import com.example.demo.repository.MyObjectRepository;

@Service
public class ObjectService {
	
	@Autowired
	private MyObjectRepository	objectrepository;
	private Map 				obj;
	//Create operation
	public String set(String key,String value) {
		obj = Map.getMapObject();
		try {
			MyObject p = objectrepository.findByKey(key);
			p.setValue(value);
			objectrepository.save(p);
		}
		catch(Exception e) {
			MyObject p= obj.set(key, value);
			objectrepository.save(p);	
		}//storing in db
		return "OK";
	}
	
	
	//Retrieve operation
	public String get(String key) {
		//first check in map if found return it, else go to database
			try {
				obj = Map.getMapObject();
				if(obj.present(key))
				{
					if(obj.get(key).isString)
					return obj.get(key).value+" from map ";
				}
				MyObject p = objectrepository.findByKey(key);
				if(p.expiry >  System.currentTimeMillis()) {
					if(p.isString) {
						obj.set(key,p.value);
						return p.value + " from db";
					}
				}
				else {
					objectrepository.delete(p);
					obj.erase(key);
				}
			}
			catch(Exception e)
			{
				
			}
			return "(nil)";
	}

	//remove item from database
	public void delete(String key) {
		try {
			MyObject p = objectrepository.findByKey(key);
			objectrepository.delete(p);//and also delete from map
		}
		catch(Exception e)
		{
			System.out.println("Key not present");
		}
	}

	//set the expire time
	public int expire(String key, int time) {
		// TODO Auto-generated method stub
		MyObject p = objectrepository.findByKey(key);
		try {
			long timestampMillis = System.currentTimeMillis();
			p.setExpiry(timestampMillis + time);
			objectrepository.save(p);
			return 1;
		}
		catch(Exception e)
		{
			System.out.print("Key not found");
		}
		return 0;
	}

	public long ttl(String key) {
		// TODO Auto-generated method stub
		MyObject p = objectrepository.findByKey(key);
		try {					//expire time - now() =ttl;
			long exp = p.getExpiry();
			long timestampMillis = System.currentTimeMillis();
			return exp - timestampMillis;
		}
		catch(Exception e)
		{
			System.out.print("Key not found");
		}
		return -1;
	}


	public void deleteAll() {
		// TODO Auto-generated method stub
		objectrepository.deleteAll();
	}


	public List<MyObject> getAll() {
		// TODO Auto-generated method stub
		return objectrepository.findAll();
	}
	
	public int zadd(String key, double score, String value) {
		// TODO Auto-generated method stub
		obj = Map.getMapObject();
		try {
			MyObject p = objectrepository.findByKey(key);
			if(p.isString == false)
			{
				p.add(score, value);			//if exist then add a value
				objectrepository.save(p);
				return 1;
			}
			else
			{
				return 0;
			}
		}
		catch(Exception e)
		{
			MyObject m = obj.addInSet(key,score,value);
			objectrepository.save(m);		//storing in db
			
		}
		return 1;
	}
	
	public String zrank(String key, String value) {	//takes O(n) times
		// TODO Auto-generated method stub
		obj = Map.getMapObject();
		try {
			MyObject p = objectrepository.findByKey(key);
			if(p.isString == false)
			{
				int i=0;
				for(pair a: p.sorter)
				{
					if(a.member.compareTo(value)==0)
					{
						double score = a.score;
						
						for(pair j: p.sorter)
						{
							if(j.score < score)
								i++;
						}
						return i+"";
					}
				}
			}
		
			
		}
		catch(Exception e)
		{
			System.out.println("Key not found in zrank");
		}
		return "(nil)";
	}
	
	public List<String> zrange(String key, double low, double high) {
		// TODO Auto-generated method stub
		obj = Map.getMapObject();
		List<String> l1 = new ArrayList<String>();
		MyObject p = objectrepository.findByKey(key);
		if(p!=null && p.isString == false)
		{
			for(pair a: p.sorter)
			{
				if(a.score >= low && a.score <= high)
				{
					l1.add(a.member);
				}
			}
		}
		return l1;
	}
}