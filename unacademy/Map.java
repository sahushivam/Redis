package com.example.demo.model;

import java.util.Hashtable;
import com.example.demo.model.MyObject;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Map {
	
	private static Map INSTANCE	=null;
	private Hashtable<String, Node> mp;
	private Node head, tail; 
	private int capacity, count; 
	private Map()
	{
		this.capacity = 10;
		mp = new Hashtable<String,Node>();
		
		MyObject dummy = new MyObject("0","0");
		head = new Node("0",dummy);
		tail = new Node("0", dummy);
		head.next = tail; 
        tail.pre = head; 
        head.pre = null; 
        tail.next = null; 
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
		Node obj = this.mp.get(key);
		if(obj!=null)
		{
			deleteNode(obj);
			addToHead(obj);
			return obj.value;
		}
		return null; 	//never return null, need to fix it.
	}
	
	public MyObject set(String key, String value)
	{
		Node obj = this.mp.get(key);
		if(obj!=null)
		{
			obj.value.value = value;
			deleteNode(obj);
			addToHead(obj);
			return obj.value;
		}
		else {
			MyObject m = new MyObject(key, value);
			obj = new Node(key,m);
			this.mp.put(key,obj);
			if (count < capacity) { 
                count++; 
                addToHead(obj); 
            } 
            else { 
                mp.remove(tail.pre.key); 
                deleteNode(tail.pre); 
                addToHead(obj); 
            } 
			return m;
		}
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
		Node obj = new Node(key,m);
		m.isString = false;
		m.add(score, value);
		this.mp.put(key, obj);
		return m;
	}
	//Cache functions
	public void addToHead(Node node) 
    { 
        node.next = head.next; 
        node.next.pre = node; 
        node.pre = head; 
        head.next = node; 
    }
	public void deleteNode(Node node) 
    { 
        node.pre.next = node.next; 
        node.next.pre = node.pre; 
    }
}