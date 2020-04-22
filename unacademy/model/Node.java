package com.example.demo.model;

public class Node {
	String key;
	MyObject value;
	Node pre;
	Node next;
	
	public Node(String key,MyObject value)
	{
		this.key = key;
		this.value = value;
	}
}
