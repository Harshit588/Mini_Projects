package ATM_MAchine_MiniProject;

import java.util.Scanner;
	
class Atm{
		
		double Balence;
		
	public void CheckPin() {
			System.out.print("Enter Your 4-Digit Pin : ");
			Scanner sc = new Scanner(System.in);
			int enterPin = sc.nextInt();
			if((String.valueOf(enterPin).length())==4) {
				Menu();
			}else {
				System.out.println("Invalid Pin!!!!!");
				System.out.println();
				CheckPin();
			}	
		}
		
	public void Menu() {
			System.out.println();
			System.out.println("----SELECT AN OPTION----");
			System.out.println("1. Check Balence ");
			System.out.println("2. Deposite Money ");
			System.out.println("3. Withdraw Money ");
			System.out.println("4. ReEnter Pin ");
			System.out.println("5. Exit ");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int opt = sc.nextInt();
			
			if(opt==1) {
				CheckBalence();
			}
			else if(opt==2) {
				DepositeMoney();
			}
			else if(opt==3) {
				WithdrawMoney();
			}
			else if(opt==4) {
				CheckPin();
			}
			else if(opt==5) {
				System.out.print("Thank You!!! ");
				Exit();
			}
			else {
				System.out.println();
				System.out.print("Invalid Option");
				System.out.println();
			}
			
			Menu();
		}
		
	public void CheckBalence() {
			System.out.println();
			System.out.print("Your Balence is "+Balence);
			System.out.println();
			
			Menu();
		}
		
	public void DepositeMoney(){
			System.out.println();
			System.out.print("Enter Deposite Money : ");
			Scanner sc = new Scanner(System.in);
			double depositeMon = sc.nextDouble();
			System.out.println("Succesful Deposite....");
			Balence = Balence+depositeMon;
			System.out.print("Available Balence is : "+Balence);
			System.out.println();
			
			Menu();
		}
		
	public void WithdrawMoney() {
			System.out.println();
			System.out.print("Enter Withdraw Money : ");
			Scanner sc = new Scanner(System.in);
			double withdrowMon = sc.nextDouble();
			
			if(Balence>=withdrowMon) {
				Balence=Balence-withdrowMon;
				System.out.println("Succesful WithDraw....");
				System.out.print("Available Balence is : "+Balence);
			}
			else
				System.out.println("InSuffient Balnece!!!!!!");
			System.out.println();
			
			Menu();
		}
		
	public void Exit() {
			System.out.println();
			System.out.println("Have A Nice Day!!!...");
			System.exit(0);
		}
}

public class ATM_Machine {
	public static void main(String[] args) {
		Atm A = new Atm();
		A.CheckPin();
	}
}