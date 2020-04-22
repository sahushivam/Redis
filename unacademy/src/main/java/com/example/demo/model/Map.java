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
		if(INSTANCE == null) {
			INSTANCE = new Map();
			System.out.println("Map is initialised");
		}
		return INSTANCE;
	}
	
	public MyObject get(String key)
	{
		MyObject m = this.mp.get(key);
		return m;
	}
	
	public MyObject set(String key, String value)
	{
		MyObject m = new MyObject(key, value);
		this.mp.put(key,m);
		return m;
	}
	
	public boolean present(String key)
	{
		System.out.print(this.mp.size());
		System.out.println(this.mp);
		return this.mp.containsKey(key);
	}

	public void erase(String key)
	{
		this.mp.remove(key);
	}
	public MyObject addInSet(String key, double score, String value) {
		// TODO Auto-generated method stub
		MyObject m = new MyObject(key,value);
		m.isString = false;
		m.add(score, value);
		this.mp.put(key, m);
		return m;
	}
}