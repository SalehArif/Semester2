package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Method {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int[] lst = new int[5];
		for(int i = 0; i<lst.length;i++) {
			System.out.print("Input: ");
			lst[i] = input.nextInt();
		}
		System.out.println(Arrays.toString(lst));
		int[] res = list(lst);
		System.out.println(Arrays.toString(res));
}
	public static int[] list(int[] lst) {
		int sum = 0;
		int max = 0;
		int min = 0;
		
		for(int i = 0; i<lst.length;i++)
			sum+=lst[i];
		for(int i = 1; i<lst.length;i++)
			if(lst[i]<lst[i-1] && lst[i-1]>lst[max])
				max=i-1;
		
		for(int i = 1; i<lst.length;i++)
			if(lst[i]>lst[i-1] && lst[i-1]<lst[min])
				min = i-1;

		int[] res = {sum,lst[max],lst[min]};
		return res;
	}
	}