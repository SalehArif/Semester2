package com.company;
import java.util.Scanner;

public class grades {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int marks = input.nextInt();
		String grade;
		boolean pass = (marks>50)? true:false;
		if(pass)
			System.out.println("You have Passed.");
			grade = (marks>60)?(marks>70)? (marks>80)? (marks>90)? "A":"B":"C":"D":" ";
			
		System.out.println(grade);
		
		
		
	}
}
