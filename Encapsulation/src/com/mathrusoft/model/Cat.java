package com.mathrusoft.model;

import interfaces.AnimalBehavior;

public class Cat implements AnimalBehavior{

	@Override
	public String speak() {
		return "Mew Mew";
	}


	@Override
	public String speakFromCallback(String speak) {
		// TODO Auto-generated method stub
		return null;
	}

}
