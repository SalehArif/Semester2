package com.company;
import java.util.Scanner;

public class subtraction_quiz {

	public static void main(String[] args) 
	{
		int num1 = (int)(Math.random()*10);
		int num2 = (int)(Math.random()*10);
		int ans;
		Scanner input = new Scanner(System.in);
		if(num2>num1) 
		{
			System.out.printf("What is %d - %d: ",num2,num1);
			ans = input.nextInt();
			if(ans==num2-num1)
				System.out.println("Correct answer");
			else
				System.out.println("wrong answer");
		}
		else
		{
			System.out.printf("What is %d - %d: ",num1,num2);
			ans = input.nextInt();
			if(ans==num1-num2)
				System.out.println("Correct answer");
			else
				System.out.println("wrong answer");
		}
	}
}
