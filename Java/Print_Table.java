package com.company;
import java.util.Scanner;

public class Print_Table{
	public static void main(String[] args)
	{
		//int sum = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		for(int i = 1; i<=10; i++) 
		{
			//sum += i;
			System.out.println(num + " * " + i + " = " + num*i);
		}
		//System.out.println(sum);
	}

}