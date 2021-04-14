package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class selection_sort {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int[] lst = new int[5];
		for(int i = 0; i<lst.length;i++) {
			System.out.print("Input: ");
			lst[i] = input.nextInt();
		}
		System.out.println(Arrays.toString(lst));
		
		
		int temp,minIndex = 0;
		for(int i =0;i<lst.length-1;i++) {
			minIndex = i;
			for(int j =i;j<lst.length;j++) {
				if(lst[j]<lst[minIndex])
					minIndex = j;
					
			}
			if(lst[minIndex]<lst[i]) {
				temp = lst[i];
				lst[i] = lst[minIndex];
				lst[minIndex] = temp;
				
			}
		}
		System.out.println(Arrays.toString(lst));
}

	}