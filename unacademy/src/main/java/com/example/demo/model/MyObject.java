package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document
public class MyObject {
	@Id
	public 		String 		id;
	public 		String	 	key,value;
	public 		boolean 	isString;
	public 		int 		expiry;
//	public static Set<pair<Integer,String> > sorter =new HashSet<MyObject.pair<Integer,String>>();
//	
//	public static class pair<first,second>{
//        public first First;
//        public second Second;
//        private pair(first First,second Second){
//            this.First = First;
//            this.Second = Second;
//        }
//    }
//	
//	public void add(Integer score, String value)
//	{
//		sorter.add(new pair(score,value));
//	}

	public MyObject(String key,String value,int time)
	{
		this.key = key;
		this.value = value;
		this.expiry = time;
	}
	
	public String getKey() {
		return key;
	}

	public int getExpiry() {
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

	public void setExpiry(int time) {
		// TODO Auto-generated method stub
		this.expiry = time;
	}
	
}
