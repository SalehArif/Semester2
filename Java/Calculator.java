package com.company;

public class Calculator {
	public static boolean isntZero;
	public int x,y;
	
	public static int mul(int x,int y) 
	{
		return x*y;
	}
	
	public static int add(int x,int y) 
	{
		return x+y;	
	}
	
	public static int sub(int x,int y)
	{
		return x-y;
	}
	
	public static int div(int x,int y)
	{
		try {
		return x/y;
		}
		catch (ArithmeticException e) {
			System.out.println("Division by zero is not possible");
			return 0;
		}
		
	}
}

