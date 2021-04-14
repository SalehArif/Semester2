package com.company;
import java.util.Scanner;

public class Reverse_list {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int[] x = new int[4];
		int[] y = new int[4];
		for(int i =0;i<=x.length-1;i++) {
			x[i] = input.nextInt();
			y[x.length-i-1] = x[i];
		}
		for(int i =0;i<=x.length-1;i++)
			System.out.println(x[i] + " " + y[i]);
}
}