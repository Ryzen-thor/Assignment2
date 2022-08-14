package Assignment2;

//Online Java Compiler
//Use this editor to write, compile and run your Java code online


import java.util.ArrayList;
import java.util.Scanner;

class Guesser{
	
	public int getGuess(){
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter the guessing number: ");
	int guessNum = scan.nextInt();
	return guessNum;
	}
}

class Player{
	
	
	public int playerNum() {
		System.out.print("Enter how many player going to play: ");
		Scanner scan = new Scanner(System.in);
		int playNum = scan.nextInt();
		return playNum;
	}
}

class Umpire{
	
	ArrayList<Integer> previousWinners = new ArrayList<>();
	public void checkGeuss() {
		Player p = new Player();
		int playerSize = p.playerNum();
		Guesser g = new Guesser();
		int guessNum = g.getGuess();
		Scanner scan = new Scanner(System.in);
		int[] players = new int[playerSize];
//		int[] winners = new int[playerSize];
		for(int i=0;i<playerSize;i++) {
			System.out.print("Enter the player " + (i+1) + " number: ");
			players[i] = scan.nextInt();
		}
		
		for( int i=0;i<playerSize;i++) {
			if(players[i]==guessNum) {
//				winners[i] = 1; 
				System.out.println();
				System.out.println("Player " + (i+1) + " won the game.");
				previousWinners.add(i+1);
			}
		}
		
		if(previousWinners.size()==0) {
			System.out.println("Ohh Unfornutely None of the player won");
		}
	}
	
	public ArrayList<Integer> getPreviousWinners(){
		return previousWinners;
	}
}

class Menu{
	
//	ArrayList<Integer> previousWinners = new ArrayList<>();
	String previousWinners;
	public void displayMenu() {

		Scanner sc = new Scanner(System.in);
		int options;
		while(true) {
			System.out.print("This is menu of the game. Select any of the option below:\n1.To Start the game\n2.Display status of previous winners"
					+ "\n3.To play again\n4.To exit the game");
			options = sc.nextInt();
			if(options==1) {
				System.out.println("Game has started");
				Umpire u = new Umpire();
				u.checkGeuss();
				previousWinners = u.getPreviousWinners().toString();
				System.out.println();


				
			}else if(options==2) {
				System.out.println("Displaying the previous winners ");
				Umpire u = new Umpire();
				System.out.println("Previous winners player were " + previousWinners );
				System.out.println();
			}else if(options==3) {
				System.out.println("To play again option");
				Umpire u = new Umpire();
				u.checkGeuss();
				previousWinners = u.getPreviousWinners().toString();
				System.out.println();
			}else if(options==4) {
				System.out.println("Exit option");
				System.out.println();
				break;
			}else {
				System.out.println("Please select the correct option");
				System.out.println();
			}
			
		}
	}
}

class GuesserGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("WelCome to the Guesser Game");
		System.out.println("----------------------------------------");
		System.out.println("------ Welcome to the Gusser Game ------");
		System.out.println("----------------------------------------");
		Menu m = new Menu();
		m.displayMenu();

		
	}

}




