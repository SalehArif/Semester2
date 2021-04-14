package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File_menu {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Choose what you want to do\n1.Data Entry\n2.Update Data\n3.Delete Entry\n4.Search\n>>> ");
		int choice = input.nextInt();
		menu(choice);
	}
	@SuppressWarnings("resource")
	public static void menu(int c) {
		
		Scanner in = new Scanner(System.in);
		if(c == 1)
			entry();
		else if(c==2) {
			System.out.print("Enter word you want to update: ");
			String s1 = in.next();
			update(s1);
			}
		else if(c ==3) {
			System.out.print("Enter Entry reference you want to delete: ");
			String s1 = in.next();
			delete(s1);
		}
		else if (c==4) {
			System.out.print("Enter Entry you want to search: ");
			String s1 = in.nextLine();
			in.close();
			search(s1);
			}
		else
			System.out.println("Sahi number di jiye please");
	}
	

	public static void entry() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Student name and Registration Number: ");
		String s1 = input.nextLine();
		
		File rec= new File("E:\\me.txt");
		
		try(FileWriter fw = new FileWriter(rec,true);){
			fw.write("\r\n");
			fw.write(s1);
		}catch(IOException e) {
		System.out.println("Aisa ni hona chahiye");
		}
	}
	
	@SuppressWarnings("resource")
	public static void update(String std) {
		File k = new File("E:\\me.txt");
		String old = "";
		try {
		BufferedReader read = new BufferedReader(new FileReader(k));
		String line = read.readLine();
		while(line!=null)
		{
			old = old + line + System.lineSeparator();
			line = read.readLine();
		}
		System.out.print("Enter string you want to update with: ");
		String  rep= new Scanner(System.in).next();
		String neu = old.replaceAll(std, rep);
		FileWriter writer = new FileWriter(k);
		writer.write(neu);
		read.close();
		writer.close();
		}catch(IOException e) {
			
		}
		}
	
	public static void delete(String std) {
		File k = new File("E:\\me.txt");
		String old = "";
		try {
		BufferedReader read = new BufferedReader(new FileReader(k));
		String line = read.readLine();
		while(line!=null)
		{
			if(!line.contains(std)) {
			old = old + line + System.lineSeparator();
			line = read.readLine();
			}
			else {
			line = read.readLine();
			continue;
			}
		}
		FileWriter writer = new FileWriter(k);
		writer.write(old);
		read.close();
		writer.close();
		}catch(IOException e) {
			
		}
	}
	public static void search(String s1) {
		File k = new File("E:\\me.txt");
		int count = 0;
		try { Scanner scan = new Scanner(k);
        while(scan.hasNext()){
        	count++;
            String line = scan.nextLine().toLowerCase().toString();
            if(line.contains(s1)){
                System.out.println("\" " +line + " \" is found at line " + count);
            }
        }
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}	
	
	
}