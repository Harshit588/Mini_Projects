package Mini_Projects;

import java.util.Scanner;
	
class Atm
{
		
		double Balence;
		static int oldPin;
		
	public void CheckPin() 
	{
		System.out.print("Enter Your 4-Digit Pin : ");
		Scanner sc = new Scanner(System.in);
		oldPin = sc.nextInt();
		
		if((String.valueOf(oldPin).length())==4)
		{
			Menu();
		}
		else 
		{
			System.out.println("Invalid Pin!!!!!");
			System.out.println();
			CheckPin();
		}	
	}
	public void CheckBalence() 
	{
		System.out.println();
		System.out.print("Your Balence is "+Balence);
		System.out.println();
		
		System.out.print("\nDo you want to Continue (y/n) : ");
		Scanner sc= new Scanner(System.in);
		char choiceMenu = sc.next().charAt(0);
		
		if((choiceMenu=='y')||(choiceMenu=='Y'))
		{
			Menu();
		}
		else if((choiceMenu=='n')||(choiceMenu=='N'))
		{
			System.out.println("\nHave A Nice Day!!!...");
			System.exit(0);
		}
		else
		{
			System.out.println("Invalid choice ...");
			System.out.println("Try Again...");
			CheckBalence();
		}
	}
		
	public void Menu()
	{
			System.out.println();
			System.out.println("----SELECT AN OPTION----");
			System.out.println("1. Check Balence ");
			System.out.println("2. Deposite Money ");
			System.out.println("3. Withdraw Money ");
			System.out.println("4. Change Pin ");
			System.out.println("5. Exit ");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int opt = sc.nextInt();
			
			if(opt==1)
			{
				CheckBalence();
			}
			else if(opt==2)
			{
				DepositeMoney();
			}
			else if(opt==3)
			{
				WithdrawMoney();
			}
			else if(opt==4)
			{
				changePin();
			}
			else if(opt==5)
			{
				System.out.print("Thank You!!! ");
				Exit();
			}
			else
			{
				System.out.println();
				System.out.print("Invalid Option");
				System.out.println();
				Menu();
			}
		}
		public void changePin()
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Your New Pin : ");
			int newPin = sc.nextInt();
			if(oldPin==newPin)
			{
				System.out.println("You Entered Same Pin as Privious \nTry Again\n");
				changePin();
			}
			else if((String.valueOf(newPin).length())==4)
			{
				System.out.println("\nSuccessFully Changed Your Pin....");
				oldPin=newPin;
				Menu();
			}
			else 
			{
				System.out.println("Try Again");
				changePin();
			}
			System.out.print("\nDo you want to Continue (y/n) : ");
			char choiceMenu = sc.next().charAt(0);
			
			if((choiceMenu=='y')||(choiceMenu=='Y'))
			{
				Menu();
			}
			else if((choiceMenu=='n')||(choiceMenu=='N')) 
			{
				System.out.println("\nHave A Nice Day!!!...");
				System.exit(0);
			}
			else 
			{
				System.out.println("Invalid choice ...");
				System.out.println("Try Again...");
				CheckBalence();
			}
		}
		
	public void DepositeMoney()
	{
			System.out.println();
			System.out.print("Enter Deposite Money : ");
			Scanner sc = new Scanner(System.in);
			double depositeMon = sc.nextDouble();
			System.out.println("Succesful Deposite....");
			Balence = Balence+depositeMon;
			System.out.print("Available Balence is : "+Balence);
			System.out.println();
			
			System.out.print("\nDo you want to Continue (y/n) : ");
			char choiceMenu = sc.next().charAt(0);
			
			if((choiceMenu=='y')||(choiceMenu=='Y'))
			{
				Menu();
			}
			else if((choiceMenu=='n')||(choiceMenu=='N')) 
			{
				System.out.println("\nHave A Nice Day!!!...");
				System.exit(0);
			}
			else
			{
				System.out.println("Invalid choice ...");
				System.out.println("Try Again...");
				CheckBalence();
			}
		}
		
	public void WithdrawMoney()
	{
			System.out.println();
			System.out.print("Enter Withdraw Money : ");
			Scanner sc = new Scanner(System.in);
			double withdrowMon = sc.nextDouble();
			
			if(Balence>=withdrowMon)
			{
				Balence=Balence-withdrowMon;
				System.out.println("Succesful WithDraw....");
				System.out.print("Available Balence is : "+Balence);
			}
			else
			{
				System.out.println("InSuffient Balnece!!!!!!");
				System.out.println();
			}
			System.out.print("\nDo you want to Continue (y/n) : ");
			
			char choiceMenu = sc.next().charAt(0);
			
			if((choiceMenu=='y')||(choiceMenu=='Y'))
			{
				Menu();
			}
			else if((choiceMenu=='n')||(choiceMenu=='N'))
			{
				System.out.println("\nHave A Nice Day!!!...");
				System.exit(0);
			}
			else 
			{
				System.out.println("Invalid choice ...");
				System.out.println("Try Again...");
				CheckBalence();
			}
		}
		
	public void Exit() 
	{
		System.out.println();
		System.out.println("Have A Nice Day!!!...");
		System.exit(0);
	}
}

public class ATM_Machine
{
	public static void main(String[] args)
	{
		Atm A = new Atm();
		A.CheckPin();
	}
}
