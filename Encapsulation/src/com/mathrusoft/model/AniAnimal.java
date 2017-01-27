package com.mathrusoft.model;

import interfaces.AnimalBehavior;

public class AniAnimal {	
	
	public void mySpeakCommand(AnimalBehavior animalBehavior){
		animalBehavior.speakFromCallback("I am speaking aniii");
	}

}
