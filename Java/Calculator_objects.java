package com.company;
import company.Calculator;

public class Calculator_objects{
	public static void main(String[] args) {
		Calculator obj1 = new Calc();
		obj1.x = 122;
		obj1.y = 2;
		Calculator obj2 = new Calc();
		
		
		System.out.println(obj1.add(obj1.x, obj1.y));
		System.out.println(obj1.mul(obj1.x, obj1.y));
		System.out.println(obj1.sub(obj1.x, obj1.y));
		obj1.y = 0;
		System.out.println(obj1.div(obj1.x, obj1.y));
	}
	
}