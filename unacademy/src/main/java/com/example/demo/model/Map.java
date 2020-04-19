package com.example.demo.model;

import java.util.Hashtable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Map {
	
	private static Map INSTANCE	=	null;
	private Hashtable<String, MyObject> mp= new Hashtable<String,MyObject>();
	private Map()
	{
		mp.clear();
	}
	
	public static Map getMapObject() //Singleton class for Map
	{
		if(INSTANCE == null)
			INSTANCE = new Map();
		return INSTANCE;
	}
	
	public MyObject get(String key)
	{
		MyObject m = mp.get(key);
		return m;
	}
	
	public void set(String key, String value, int time)
	{
		MyObject m = new MyObject(key, value, time);
		mp.put(key,m);
	}
	
	public boolean present(String key)
	{
		return mp.contains(key);
	}
	
	
	public void erase(String key)
	{
		mp.remove(key);
	}
	
	

	
}
