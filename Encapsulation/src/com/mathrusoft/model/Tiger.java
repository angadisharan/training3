package com.mathrusoft.model;

import interfaces.AnimalBehavior;

public class Tiger implements AnimalBehavior{

	@Override
	public String speak() {
		return "Rorrr Rorrr";
	}

	@Override
	public String speakFromCallback(String speak) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
