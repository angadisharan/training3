package com.mathrusoft.model;

import interfaces.AnimalBehavior;

public class Dog implements AnimalBehavior{

	@Override
	public String speak() {
		return "Bow Bow";
	}

	@Override
	public String speakFromCallback(String speak) {
		// TODO Auto-generated method stub
		return null;
	}

}
