package com.mathrusoft;

import interfaces.AnimalBehavior;

import com.mathrusoft.model.AniAnimal;
import com.mathrusoft.model.Cat;
import com.mathrusoft.model.Dog;
import com.mathrusoft.model.Tiger;

public class MyMainAnimalBehavior {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		Tiger tiger = new Tiger();

		System.out.println(" Running");

		AnimalBehavior animalCommand = new AnimalBehavior() {
			@Override
			public String speak() {
				return null;
			}
			
			@Override
			public String speakFromCallback(String speak) {
				System.out.println(" speak " + speak);
				return null;
			}
		};		
//		animalCommand = tiger;
//		System.out.println(animalCommand.speak());
	
		AniAnimal aniAnimal = new AniAnimal();
		aniAnimal.mySpeakCommand(animalCommand);
		
	}
	
}
