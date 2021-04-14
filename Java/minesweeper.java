package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

// Fill - Used to fill string arrays with a certain character
// Diff - Used to choose difficulty of the game to define the board size
// printBoard - Used to simply print an empty board to play the game on
// move - Used to show values on the board when a row and column is inputed
//isBomb - Checks a certain index for its value, whether its a bomb or not
//boardGen - Used to generate a board with bombs and numbers
//Win - Checks if the board is completely opened and the game is won
//gameend- Checks if a bomb has been opened and the game ends
//flagging - Used to flag indexes on the board
//zero - This method opens multiple indexes when 0 is opened in the board
//Bombs - Prints all bombs on board when game ends

public class minesweeper {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//Declarations
		System.out.println("Hello!! Welcome to Minesweeper.\n\nThe game in which you have to clear the board while avoiding mines\n"
		+ "Let's get right into it!!"); //Welcome Message
		String again = "y";
		while(again.equals("y")) {
		int diff = diff(); //Choosing Difficulty
		String[][] lst = new String[diff][diff]; //Making Boards for playing
		String[][] lst1 = new String[diff][diff];
		fill(lst1, "0");
		fill(lst,"-");
		int[] move = new int[2];
		int bcount;
		int score = 0;
		String flag;
		//Current Board Generate
		
		
		//Generating board for the game once
		bcount = boardGen(lst1,diff);
		
		//printBoard(lst1,diff);
		System.out.println();
		printBoard(lst,bcount,score);
		
		while(true) {
		//Taking input
			try {
		System.out.print("\nEnter Number of Row (space) Column to Open: ");
		move[0] = input.nextInt();
		move[1] = input.nextInt();
		if(lst[move[0]][move[1]].equals("F")) {
			System.out.println("\nSorry! The Position is already flagged\n");
			continue;
		}
			}catch(InputMismatchException e) {
				System.out.println("\nGive a number");
				continue;
			}
		
		score = move(move,lst,lst1,score);
		printBoard(lst,bcount,score);
		if(Win(lst,bcount)){
			System.out.println("\nHey! Congratulations, Its a celebration!! I mean.....\nYou Win!!\n");
			printBoard(lst,diff,score);
			break;}
		else if(gameend(lst1,move)) {
			System.out.println("\nGame Over. You stepped on a land mine there.");
			Bombs(lst,lst1,score);
			System.out.print("\nWanna Play Again? :)\nY/N: ");
			again = input.next().toLowerCase();
			break;}
		
		System.out.print("\nDo you want to Flag any position as a Mine(Y/N): ");
		flag = input.next().toLowerCase();
		if(flag.equals("y"))
			bcount = flagging(lst,lst1,bcount);
		printBoard(lst,bcount,score);
		}
		if(again.equals("n"))
			System.out.print("\nBye :)");
			break;
		}
	}
	public static void fill(String[][] lst,String word) {
		for(int i=0;i<lst.length;i++)
			for(int j=0;j<lst[0].length;j++)
				lst[i][j] = word;
	}
	public static int diff() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("\nChoose Difficulty:\n 1 for Easy\n 2 for Medium\n 3 for Hard: ");
		int diff = input.nextInt();
		
		while(diff>3 && diff<=0) {
			System.out.print("Invalid Input! Choose again: ");
			diff = input.nextInt();
		}
		if(diff==1)
			return 9;
		else if(diff == 2)
			return 16;
		else
			return 24;
	}
	
	public static void printBoard(String[][] lst, int bcount,int score) {
		
		
		for(int i=0;i<lst.length;i++) {
			if(i==0) {
				System.out.print("\n\t\t\tYour Score: " + score);
				System.out.println("\n\t\t\tBombs left: " + bcount);
				System.out.print("\n\t\t\t\t");
				for(int j =0;j<lst.length;j++)
					System.out.print(j + " ");
				System.out.println("\n");
			}
			if(i<10)
			System.out.print("\t\t\t" + i + "\t");
			else
				System.out.print("\t\t\t" + i + "\t");	
			for(int j=0;j<lst.length;j++) {
				if(j>9)
				System.out.print(lst[i][j] + "  ");
				else
					System.out.print(lst[i][j] + " ");
			
			}
		System.out.println();
		}}
	
	public static int move(int[] move,String[][] lst,String[][] lst1,int score) {
		
		boolean isZero = lst1[move[0]][move[1]].equals("0");
		// 1. just print number
		if(!isZero && !isBomb(lst1,move[0],move[1])) {
			lst[move[0]][move[1]] = lst1[move[0]][move[1]];
			score += Integer.parseInt(lst1[move[0]][move[1]]);
		}
		//2. end game on bomb
		else if(isBomb(lst1,move[0],move[1]))
			lst[move[0]][move[1]] = "B";
			
		
		// 3. Open all zeros and a certain number of numbers	
		else if(isZero)
			score = zero(lst,lst1,move,score);
		return score;
	} 
	
	public static boolean isBomb(String[][] lst, int row,int col) {
		if(lst[row][col].equals("B"))
			return true;
		return false;
	}
	public static int boardGen(String[][] lst, int diff){
		// dif = Difficulty()
		// min = get mines num from difficulty
		
		//generate bombs
		
		int min = 0;
		if(diff == 9)
			min = 10;
		else if(diff == 16)
			min=40;
		else if(diff==24)
			min=99;
		
		for(int i=0;i<min;) {
		int rand = (int) (Math.random()*(diff-1));
		int rand1 = (int) (Math.random()*(diff-1));
		if(lst[rand][rand1].equals("B"))
				continue;
		i++;
		lst[rand][rand1] = "B"; //Bomb
		}
		// count bombs in adjacent cells
		for(int i=0;i<lst.length;i++) {
			for(int j=0;j<lst.length;j++) {
				int count = 0;
				if(!(lst[i][j].equals("B"))) {
				for(int k=i-1;k<i+2;k++) {
					try {
					if(lst[k][j].equals("B"))
						count+=1;
					if(lst[k][j-1].equals("B"))
						count+=1;
					if(lst[k][j+1].equals("B"))
						count+=1;
					}catch(ArrayIndexOutOfBoundsException e) {
						continue;
					}
				
				}
				lst[i][j] = Integer.toString(count);}}
					}
			return min;
				
	}
	public static boolean Win(String[][] lst,int bcount){
		if(bcount==0)
			return true;
		for(int i=0;i<lst.length;i++)
			for(int j=0;j<lst.length;j++)
				if(lst[i][j].equals("-"))
					return false;
		return true;
	}
	
	public static boolean gameend(String[][] lst,int[] move){
		
		if(lst[move[0]][move[1]].equals("B"))
			return true;
		return false;
	}
	
	public static int flagging(String[][] lst,String[][] lst1,int bCount) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int[] flag = new int[2];
		System.out.print("\nEnter Number of Row (space) Column to Flag: ");
		flag[0] = input.nextInt();
		flag[1] = input.nextInt();
		if(lst[flag[0]][flag[1]].equals("-"))
			lst[flag[0]][flag[1]] = "F";
		else
			System.out.println("\nSorry! The spot is already opened");
		if (isBomb(lst1,flag[0],flag[1]))
			bCount--;
		return bCount;
	}
	
	public static int zero(String[][] lst,String[][] lst1,int[] move,int score) {
		lst[move[0]][move[1]] = "0";
		int i=0;
		
		while(true) { //right
			try {
			i++;
			if(lst1[move[0]][move[1]+i].equals("0"))
				lst[move[0]][move[1]+i]="0";
			else if(Integer.parseInt(lst1[move[0]][move[1]+i]) > 0) {
				lst[move[0]][move[1]+i] = lst1[move[0]][move[1]+i];
				score += Integer.parseInt(lst1[move[0]][move[1]+i]);
				break;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			break;}
		catch(NumberFormatException e) {
				break;}	
		}
		
		i=0;
		while(true) { //left
			try {
			i++;
			if(lst1[move[0]][move[1]-i].equals("0"))
				lst[move[0]][move[1]-i]="0";
			else if(Integer.parseInt(lst1[move[0]][move[1]-i]) > 0) {
				lst[move[0]][move[1]-i] = lst1[move[0]][move[1]-i];
				score += Integer.parseInt(lst1[move[0]][move[1]-i]);
				break;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			break;}catch(NumberFormatException e) {
				break;}}
		
		i=0;
		while(true) { //up
			try {
			i++;
			if(lst1[move[0]-i][move[1]].equals("0"))
				lst[move[0]-i][move[1]]="0";
			else if(Integer.parseInt(lst1[move[0]-i][move[1]]) > 0) {
				lst[move[0]-i][move[1]] = lst1[move[0]-i][move[1]];
				score +=  Integer.parseInt(lst1[move[0]-i][move[1]]);
				break;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			break;}catch(NumberFormatException e) {
				break;}}
		i=0;
		while(true) { //down
			try {
			i++;
			if(lst1[move[0]+i][move[1]].equals("0"))
				lst[move[0]+i][move[1]]="0";
			else if(Integer.parseInt(lst1[move[0]+i][move[1]]) > 0) {
				lst[move[0]+i][move[1]] = lst1[move[0]+i][move[1]];
				score += Integer.parseInt(lst1[move[0]+i][move[1]]);
				break;
			}
			}catch(ArrayIndexOutOfBoundsException e) {
				break;}catch(NumberFormatException e) {
					break;}}
		i=0;
		int j=0;
		while(true) { //up left
			try {
			i++;
			if(lst1[move[0]-i][move[1]-i].equals("0")) {
				lst[move[0]-i][move[1]-i]="0";
				j=0;
				while(true) {
					j++;
					if(lst1[move[0]-i][move[1]-i-j].equals("0"))
						lst[move[0]-i][move[1]-i-j]="0";
					else if(Integer.parseInt(lst1[move[0]-i][move[1]-i-j]) > 0) {
						lst[move[0]-i][move[1]-i-j] = lst1[move[0]-i][move[1]-i-j];
						score += Integer.parseInt(lst1[move[0]-i][move[1]-i-j]);
						break;
				}}
				j=0;
				while(true) {
					j++;
					if(lst1[move[0]-i-j][move[1]-i].equals("0"))
						lst[move[0]-i-j][move[1]-i]="0";
					else if(Integer.parseInt(lst1[move[0]-i-j][move[1]-i]) > 0) {
						lst[move[0]-i-j][move[1]-i] = lst1[move[0]-i-j][move[1]-i];
						score+= Integer.parseInt(lst1[move[0]-i-j][move[1]-i]);
						break;
				}
				}}
				
			else if(Integer.parseInt(lst1[move[0]-i][move[1]-i]) > 0) {
				lst[move[0]-i][move[1]-i] = lst1[move[0]-i][move[1]-i];
				Integer.parseInt(lst1[move[0]-i][move[1]-i]);
				break;
			}
			}catch(ArrayIndexOutOfBoundsException e) {
				break;}catch(NumberFormatException e) {
					break;}}
		i=0;
		while(true) { //up right
			try {
			i++;
			if(lst1[move[0]-i][move[1]+i].equals("0")) {
				lst[move[0]-i][move[1]+i]="0";
				j=0;
				while(true) {
					j++;
					if(lst1[move[0]-i][move[1]+i+j].equals("0"))
						lst[move[0]-i][move[1]+i+j]="0";
					else if(Integer.parseInt(lst1[move[0]-i][move[1]+i+j]) > 0) {
						lst[move[0]-i][move[1]+i+j] = lst1[move[0]-i][move[1]+i+j];
						score+= Integer.parseInt(lst1[move[0]-i][move[1]+i+j]);
						break;
				}}
				j=0;
				while(true) {
					j++;
					if(lst1[move[0]-i-j][move[1]+i].equals("0"))
						lst[move[0]-i-j][move[1]+i]="0";
					else if(Integer.parseInt(lst1[move[0]-i-j][move[1]+i]) > 0) {
						lst[move[0]-i-j][move[1]+i] = lst1[move[0]-i-j][move[1]+i];
						score += Integer.parseInt(lst1[move[0]-i-j][move[1]+i]);
						break;
				}
			}}
			else if(Integer.parseInt(lst1[move[0]-i][move[1]+i]) > 0) {
				lst[move[0]-i][move[1]+i] = lst1[move[0]-i][move[1]+i];
				score += Integer.parseInt(lst1[move[0]-i][move[1]+i]);
				break;
			}
			}catch(ArrayIndexOutOfBoundsException e) {
				break;}catch(NumberFormatException e) {
					break;}}
		i=0;
		while(true) { //down left
			try {
			i++;
			if(lst1[move[0]+i][move[1]-i].equals("0")) {
				lst[move[0]+i][move[1]-i]="0";
				j=0;
				while(true) {
					j++;
					if(lst1[move[0]+i][move[1]-i-j].equals("0"))
						lst[move[0]+i][move[1]-i-j]="0";
					else if(Integer.parseInt(lst1[move[0]+i][move[1]-i-j]) > 0) {
						lst[move[0]+i][move[1]-i-j] = lst1[move[0]+i][move[1]-i-j];
						score += Integer.parseInt(lst1[move[0]+i][move[1]-i-j]);
						break;
				}}
				j=0;
				while(true) {
					j++;
					if(lst1[move[0]+i+j][move[1]-i].equals("0"))
						lst[move[0]+i+j][move[1]-i]="0";
					else if(Integer.parseInt(lst1[move[0]+i+j][move[1]-i]) > 0) {
						lst[move[0]+i+j][move[1]-i] = lst1[move[0]+i+j][move[1]-i];
						score += Integer.parseInt(lst1[move[0]+i+j][move[1]-i]);
						break;
				}	
			}}
			else if(Integer.parseInt(lst1[move[0]+i][move[1]-i]) > 0) {
				lst[move[0]+i][move[1]-i] = lst1[move[0]+i][move[1]-i];
				score += Integer.parseInt(lst1[move[0]+i][move[1]-i]);
				break;
			}
			}catch(ArrayIndexOutOfBoundsException e) {
				break;}catch(NumberFormatException e) {
					break;}}
		i=0;
		while(true) { //down right
			try {
			i++;
			if(lst1[move[0]+i][move[1]+i].equals("0")) {
				lst[move[0]+i][move[1]+i]="0";
				j=0;
				while(true) {
					j++;
					if(lst1[move[0]+i][move[1]+i+j].equals("0"))
						lst[move[0]+i][move[1]+i+j]="0";
					else if(Integer.parseInt(lst1[move[0]+i][move[1]+i+j]) > 0) {
						lst[move[0]+i][move[1]+i+j] = lst1[move[0]+i][move[1]+i+j];
						score+= Integer.parseInt(lst1[move[0]+i][move[1]+i+j]);
						break;
				}}
				j=0;
				while(true) {
					j++;
					if(lst1[move[0]+i+j][move[1]+i].equals("0"))
						lst[move[0]+i+j][move[1]+i]="0";
					else if(Integer.parseInt(lst1[move[0]+i+j][move[1]+i]) > 0) {
						lst[move[0]+i+j][move[1]+i] = lst1[move[0]+i+j][move[1]+i];
						score += Integer.parseInt(lst1[move[0]+i+j][move[1]+i]);
						break;
				}
			}}
			else if(Integer.parseInt(lst1[move[0]+i][move[1]+i]) > 0) {
				lst[move[0]+i][move[1]+i] = lst1[move[0]+i][move[1]+i];
				score += Integer.parseInt(lst1[move[0]+i][move[1]+i]);
				break;
			}
			}catch(ArrayIndexOutOfBoundsException e) {
				break;}catch(NumberFormatException e) {
					break;}}
		return score;
	}
	public static void Bombs(String[][] lst,String[][] lst1,int score) {
		for(int i=0;i<lst.length;i++) {
			if(i==0) {
				System.out.print("\n\t\t\tYour Score: " + score);
				System.out.print("\n\t\t\t\t");
				for(int j =0;j<lst.length;j++)
					System.out.print(j + " ");
					System.out.println("\n");
				}
				if(i<10)
					System.out.print("\t\t\t" + i + "\t");
				else
					System.out.print("\t\t\t" + i + "\t");	
				for(int j=0;j<lst.length;j++) {
					if(j>9) {
						if(lst1[i][j].equals("B"))
							System.out.print(lst1[i][j] + "  ");
						else
							System.out.print(lst[i][j] + "  ");}
					else {
						if(lst1[i][j].equals("B"))
							System.out.print(lst1[i][j] + " ");
						else
							System.out.print(lst[i][j] + " ");
					}
				}
			System.out.println();
				
			}}
}
