package com.company;
import java.util.Scanner;

public class Prime_number{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		boolean isPrime = true;
		for(int i = num-1; i>1 ; i--)
		{
			if(num%i==0)
			{
				isPrime = false;
				break;
			}
		}
		
		if(isPrime)
			System.out.println(num + "is a prime number");
		else
			System.out.println(num + "is not a prime number");
	}
}
