package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class insertion_sort {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int[] lst = new int[5];
		for(int i = 0; i<lst.length;i++) {
			System.out.print("Input: ");
			lst[i] = input.nextInt();
		}
		System.out.println(Arrays.toString(lst));
		
		
		int temp,key = 0;
		for(int i =0;i<lst.length;i++) {
			key = lst[i];
			int j = i-1;
			while(j >=0 && key<lst[j]) {
				temp = lst[j];
				lst[j] = lst[j+1];
				lst[j+1] = temp;
				j--;
			}
			
		}
		System.out.println(Arrays.toString(lst));
}

	}