
package com.company;
import java.util.Scanner;

public class Exceptions {
	public static int num = 10;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int[] lst = {1,2,3,4,5};
		String x = null;
		try {
			System.out.println(num1/num2);
			x.length();
			System.out.println(lst[5]);
			
		}
		catch(ArithmeticException e){
			System.out.println("Zero Division Error");
		}
		catch(NullPointerException e){
			System.out.println("Variable has null value");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Index isn't in the Array");
		}
	}
}