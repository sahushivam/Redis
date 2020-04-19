package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Map;
import com.example.demo.model.MyObject;
import com.example.demo.repository.MyObjectRepository;

@Service
public class ObjectService {
	
	@Autowired
	private MyObjectRepository	objectrepository;
	private Map 				obj;
	private MyObject 			mobj;
	//Create operation
	public String set(String key,String value) {
		obj = Map.getMapObject();
		int defaultexpire=12;
		obj.set(key,value,defaultexpire);											// storing in map
		objectrepository.save(new MyObject(key, value,defaultexpire));		//storing in db
		return "OK";
	}
	
	public String set(String key, String value, String sec, int time) {
		if(sec.compareTo("EX")==0)
		{
			time = time * 1000;
			//convert into milliseconds and add now.time() + time
			obj.set(key, value,time);
		}
		else
		{
			obj.set(key, value,time);
		}
		return "OK";
	}
	
	//Retrieve operation
	public String get(String key) {
		//first check in map if found return it, else go to database
		if(obj.present(key)) {
			mobj =  obj.get(key);
			int time_now=10;						//get the time and compare
			if(mobj.expiry > time_now || mobj.isString == false)
			{
				return "nil";			//object not found
			}
			else
			{
				return mobj.value;
			}
		}
		else//also check if it has got expire than delete from map and database
		{	
			MyObject mobj = objectrepository.findByKey(key);
			int time_now=10;			//get the time and compare
			if(mobj == null || mobj.expiry > time_now || mobj.isString == false)
			{
				return "nil";			//object not found
			}
			else
			{
				obj.set(key,mobj.value,time_now);
				return mobj.value;
			}
		}
	}

	//remove item from database
	public void delete(String firstName) {
		MyObject p = objectrepository.findByKey(firstName);
		objectrepository.delete(p);//and also delete from map
	}

	//set the expire time
	public int expire(String key, int time) {
		// TODO Auto-generated method stub
		MyObject p = objectrepository.findByKey(key);
		if(p!=null) {
			p.setExpiry(time);
			objectrepository.save(p);
			if(obj.present(key))			//if object present in map
			{
				obj.erase(key);
				obj.set(key,p.value,time);
			}
			return 1;
		}
		else
		{
			return 0;
		}
	}

	public int ttl(String key) {
		// TODO Auto-generated method stub
		MyObject p = objectrepository.findByKey(key);
		if(p!=null) {					//expire time - now() =ttl;
			int exp = p.getExpiry();
			int now = 1000;						//set the time now
			return exp - now;
		}
		return -1;
	}
	
	//ttl
}
