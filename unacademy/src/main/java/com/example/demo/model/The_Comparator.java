package com.example.demo.model;

import java.util.Comparator;

import com.example.demo.model.MyObject.pair;

public class The_Comparator implements Comparator<MyObject.pair> {

	@Override
	public int compare(pair arg0, pair arg1) {
		// TODO Auto-generated method stub
		return arg0.First - arg1.First;
	}
}
