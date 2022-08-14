//Assignment 2.0

import java.util.ArrayList;
import java.util.Scanner;


//class for guesser there is only one method and it will return guess number
class Guesser{
	
	public int getGuess(){
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter the guessing number: ");
	int guessNum = scan.nextInt();
	return guessNum;
	}
}

// this player class will return number of player after asking from user 
class Player{
	
	
	public int playerNum() {
		System.out.print("Enter how many player going to play: ");
		Scanner scan = new Scanner(System.in);
		int playNum = scan.nextInt();
		return playNum;
	}
}


// this class will call player num and it will create array of size of that. And it will also get the guess number from
// guesser class and through for loop it will get all the player number. Then again with for loop every player
// elemnt in array will be checked with guess number and once if condition pass we will print that player
// we are also saving player who are winners to get the previous winners
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
			System.out.println();
			System.out.println("Ohh Unfornutely None of the player won");
		}
	}
	
	public ArrayList<Integer> getPreviousWinners(){
		return previousWinners;
	}
}


// this class is menu and it have all the options and it is calling umpire to start the game
class Menu{
	

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




