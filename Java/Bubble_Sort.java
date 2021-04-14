package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Bubble_Sort {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int[] lst = new int[5];
		for(int i = 0; i<lst.length;i++) {
			System.out.print("Input: ");
			lst[i] = input.nextInt();
		}
		System.out.println(Arrays.toString(lst));
		int temp = 0;
		for(int i =0;i<lst.length-1;i++) {
			for(int j =0;j<lst.length-1-i;j++) {
				if(lst[j]>lst[j+1])
					temp = lst[j];
					lst[j] = lst[j+1];
					lst[j+1] = temp;
					
			}
		}
		System.out.println(Arrays.toString(lst));
}

	}