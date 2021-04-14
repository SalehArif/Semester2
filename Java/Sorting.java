package com.company;
import java.util.Scanner;
public class Sorting {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Sort by?\n1.Marks\n2.Name\n3.Registration Number");
		int choice = input.nextInt();
		menu(choice);
	}
	
	public static void menu(int c) {
		String[] name = {"Abdullah","Shehryar Ayaz",
				"Saima Aftab","Hina Malik","Makhdoom Fayaz"};
		String[] reg = {"SP19-BCS-001","SP19-BCS-015",
				"SP19-BCS-048","SP19-BCS-035","SP19-BCS-012"};
		int[] mark = {87,92,83,79,86};
		
		if(c==1)
			marks(mark,name,reg);
		else if(c==2)
			name(name,reg,mark);
		else if(c==3)
			reg(reg,name,mark);
	}
	
	public static void marks(int[] lst,String[] nam,String[] reg) {
		int max = 0;
		int temp = 0;
		String tem; 
		for(int i=0;i<lst.length-1;i++) {
			for(int j=0;j<lst.length-1-i;j++)
				if(lst[j+1]>lst[j]) {
					temp = lst[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
					lst[j] = lst[j+1];
					lst[j+1] = temp;
					tem = nam[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
					nam[j] = nam[j+1];
					nam[j+1] = tem;
					tem = reg[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
					reg[j] = reg[j+1];
					reg[j+1] = tem;
					
				}}
		for(int i=0;i<lst.length;i++)
			System.out.println(lst[i] + " " + nam[i] + " " + reg[i]);
		
	}			
	
	public static void name(String[] lst,String[] reg,int[] nam) {
		int tem;
		String temp = null;
		for(int i=0;i<lst.length-1;i++)
			for(int j=0;j<lst.length-1-i;j++) {
				if(lst[j+1].charAt(0)<lst[j].charAt(0)) {
					temp = lst[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
					lst[j] = lst[j+1];
					lst[j+1] = temp;
					tem = nam[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
					nam[j] = nam[j+1];
					nam[j+1] = tem;
					temp = reg[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
					reg[j] = reg[j+1];
					reg[j+1] = temp;
			}
				else if(lst[j+1].charAt(0)==lst[j].charAt(0))
					if(lst[j+1].charAt(1)<lst[j].charAt(1))
					{
						temp = lst[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
						lst[j] = lst[j+1];
						lst[j+1] = temp;
						tem = nam[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
						nam[j] = nam[j+1];
						nam[j+1] = tem;
						temp = reg[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
						reg[j] = reg[j+1];
						reg[j+1] = temp;
				}
				}
		for(int i=0;i<lst.length;i++)
			System.out.println(lst[i] + " " + nam[i] + " " + reg[i]);
		
	}
	
	public static void reg(String[] lst,String[] nam, int[] reg) {
		String[] s = lst[0].split("-");
		String[] s1 = lst[1].split("-");
		int tem;
		String temp;
		
		for(int i=0;i<lst.length;i++)
			for(int j=0;j<lst.length-1-i;j++) {
				s = lst[j].split("-");
				s1 = lst[j+1].split("-");
				if(Integer.parseInt(s1[2])<Integer.parseInt(s[2])) {
					temp = lst[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
					lst[j] = lst[j+1];
					lst[j+1] = temp;
					temp = nam[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
					nam[j] = nam[j+1];
					nam[j+1] = temp;
					tem = reg[j];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
					reg[j] = reg[j+1];
					reg[j+1] = tem;
			}
	}
		for(int i=0;i<lst.length;i++)
			System.out.println(lst[i] + " " + nam[i] + " " + reg[i]);
		
}
}