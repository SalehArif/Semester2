package com.company;
import java.util.Scanner;

public class Password_validator {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		String pass = input.next();
		while(pass.length()<8)
			pass = input.next();
		char[] s = pass.toCharArray();
		int count=0;
		for(int i=0;i<s.length;i++) {
			if(!Character.isLetterOrDigit(s[i])) {
					System.out.println("Invalid Pass");
					break;}
			if(Character.isDigit(s[i]))
					count++;
		}
		if(count<2)
			System.out.println("Invalid Pass");
}}