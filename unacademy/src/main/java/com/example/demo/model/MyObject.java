package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
import java.util.TreeSet;

@Document
public class MyObject {
	@Id
	public		String		id;
	@Indexed
	public 		String	 	key;
	public		String		value;
	public 		boolean 	isString;
	public 		long 		expiry;
	
	public static class pair{
        public int First;
        public String Second;
        private pair(Integer First, String Second) {
			// TODO Auto-generated constructor stub
        	this.First = First;
        	this.Second = Second;
		}
    }
	public Set<pair> sorter =new TreeSet<MyObject.pair>(new The_Comparator());

	public void add(Integer score, String value)
	{
		sorter.add(new pair(score, value));
	}

	public MyObject(String key,String value)
	{
		long DEFAULT = 999999999999999L;
		this.key = key;
		this.value = value;
		this.isString = true;
		this.expiry =  System.currentTimeMillis()+DEFAULT; 
	}
	
	public String getKey() {
		return key;
	}

	public long getExpiry() {
		return expiry;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString()
	{
		return "Key is" + key + ": value" + value;
	}

	public void setExpiry(long expiry) {
		// TODO Auto-generated method stub
		this.expiry = expiry;
	}
	
}