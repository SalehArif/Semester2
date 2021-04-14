package com.company;
import java.util.Scanner;

public class Diamond_pattern{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/*
		 *    *
		 *   **
		 *  ***
		 * ****
		 */
		for(int i=0;i<4;i++) {
			for(int j=0;j<=4-i;j++)
				System.out.print(" ");
			for(int j=0;j<=i*2;j++)
				System.out.print("*");
			
			System.out.println();
		}
		
		for(int i=4;i>=0;i--) {
			for(int j=0;j<=4-i;j++)
				System.out.print(" ");
			for(int j=0;j<=i*2;j++)
				System.out.print("*");
			
			System.out.println();
		}
		int s;
		for(int i=0;i<5;i++) {
			s=5;
			for(int j=0;j<=i;j++) {
				System.out.print(s);
				s--;}
			System.out.println();
		}
		
		
}}