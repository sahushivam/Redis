package com.example.demo.controller;

import java.util.List;

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
		String ok = objectService.set(key, value);
		return ok;
	}
	
	@RequestMapping("/get")
	public String getObject(@RequestParam String key){
			return objectService.get(key);
	}
	
	@RequestMapping("/expire")
	public int expire(@RequestParam String key, @RequestParam int time){
		return objectService.expire(key,time);
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String key) {
		objectService.delete(key);
		return "Deleted "+key;
	}
	@RequestMapping ("/deleteAll")
	public String deleteAll() {
		objectService.deleteAll();
		return "Deleted all records";
	}
	
	@RequestMapping("/getAll")
	public List<MyObject> getAll(){
		return objectService.getAll();
	}
	
	@RequestMapping("zadd")
	public int zadd(@RequestParam String key, @RequestParam int score, @RequestParam String value) {
		return objectService.zadd(key, score, value);
	}
	
	@RequestMapping("zrank")
	public String zrank(@RequestParam String key, @RequestParam String value) {
		return objectService.zrank(key, value);
	}	
	
	@RequestMapping("zrange")
	public List<String> zrange(@RequestParam String key, @RequestParam int low, @RequestParam int high){
		return objectService.zrange(key,low,high);
	}
}