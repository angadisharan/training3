package com.mathrusoft.model;

import com.mathrusoft.AbstractAnimal;

public class DemoAbsCat extends AbstractAnimal{

	@Override
	public String speak() {
		return "Mew Mew";
	}
	
	@Override
	public void walk(){
		super.walk();
		System.out.println("Cat walk");
	}
	
}
