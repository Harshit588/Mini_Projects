package Guesser_Game;

import java.util.Scanner;

class Guesser{
	
	public int GuessorNum() {
		System.out.print("Hey... Guessor Plaese Take a Number : ");
		Scanner scan = new Scanner(System.in);
		int guessorNum = scan.nextInt();
		return guessorNum;
	}
}

class Players{
	
	public int Player(int i) {
		System.out.print("Hey... Player Num "+i+" Please Enter Your Number : ");
		Scanner scan = new Scanner(System.in);
		int playerNum = scan.nextInt();
		return playerNum;
	}
}

class umpire{
	int GuessorNo;
	int Playerno1;
	int Playerno2;
	int Playerno3;
	
	public void collectFromGuessor() {
		Guesser G = new Guesser();
		GuessorNo = G.GuessorNum();
	}
		
	public void collectFromPlayer() {	
		Players P1 = new Players();
		Playerno1 = P1.Player(1);
		
		Players P2 = new Players();
		Playerno2 = P2.Player(2);

		Players P3 = new Players();
		Playerno3 = P3.Player(3);
	}
	
	public void Compare() {
		if(Playerno1==GuessorNo) {
			if(Playerno1==Playerno2&&Playerno1==Playerno3) {
				System.out.print("All are Won ");
			}else if (Playerno1==Playerno2) {
				System.out.print("Player 1 and Player 2 Won The game... ");
			}else if(Playerno1==Playerno3) {
				System.out.print("Player 1 and Player 3 Won The game... ");
			}else {
				System.out.print("Player 1 Won The game...");
			}
		}
		else if(Playerno2==GuessorNo) {
			if(Playerno2==Playerno3) {
				System.out.print("Player 2 and Player 3 Won The game... ");
			}else {
				System.out.print("Player Number 2 Won the game...");
			}
		}
		if(GuessorNo==Playerno3){
			System.out.print("Player Number 3 Won the game...");
		}
		else {		
			System.out.println("No One Won the Game...");
		}
	}
}	

public class MyGuessorGame {

	public static void main(String[] args) {
		
		System.out.println("---Start The Game---"); 
		umpire U = new umpire();
		U.collectFromGuessor();
		U.collectFromPlayer();
		U.Compare();
		System.out.println();
		System.out.println("---End The Game---");
	}
}