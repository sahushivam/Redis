package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MyObject;
import com.example.demo.service.ObjectService;


@RestController
public class MyObjectController {
	
	@Autowired
	private ObjectService objectService;
	
	@RequestMapping("/set")
	public String set(@RequestParam String key, @RequestParam String value) {
		int time = 1000;								//default time
		String ex="EX";
		String ok = objectService.set(key, value, ex, time);
		return ok;
	}
	
	@RequestMapping("/get")
	public String getObject(@RequestParam String key){
		return objectService.get(key);
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String key) {
		objectService.delete(key);
		return "Deleted "+key;
	}
}
