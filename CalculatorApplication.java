package Mini_Projects;

import java.util.Scanner;

public class CalculatorApplication {

	public static void main(String[] args) {

		CalculatorApplication ca = new CalculatorApplication();
		ca.retryLogic();
	}
	public void retryLogic() {

		CalculatorApplication ca = new CalculatorApplication();
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println();
			System.out.println("Choose An Opration ( + , - , * , / , % ): ");
			System.out.print("-----> ");
			
			char option = sc.next().charAt(0);
			
			ca.chooseOperation(option);
			
			int i=0;
			for(i = 1; i<=5;i++) {
			
				System.out.println();
				System.out.println("Do You Want To Continuee (y/n) : ");
				char exitInput = sc.next().charAt(0);
				
				if(exitInput=='n' || exitInput=='N') {
					System.out.println();
					System.out.println("Thank You Have A Nice Day....");
					System.exit(0);				
				}
				if(exitInput=='y'||exitInput=='Y') {
					break;
				}
				else if(exitInput != 'y') {
					System.out.println("You Have 5 Time To Re-Try...");
					System.out.println("Its your "+i+" Time Wrong Input Try Again...");
				}
			}
			if(i>=5) {
				System.out.println();
				System.out.println("MiniMum ReTry is Over So Bye....");
				System.out.println();
				System.out.println("Thank You Have A Nice Day....");
				System.exit(0);	
			}
		}while(true);
	}
	public int UserInputNum() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number: ");
		int num=sc.nextInt();
		return num;
	}
	public void chooseOperation(char ch) {
		switch(ch){
		case '+' :
			
			int num1 = UserInputNum();
			int num2 = UserInputNum();
			System.out.println();
			
			System.out.println("Addition is : "+(num1+num2));
			break;

		case '-' :
			
			int num3 = UserInputNum();
			int num4 = UserInputNum();
			System.out.println();
			
			System.out.println("Substraction is : "+(num3-num4));
			break;

		case '*' :
			
			int num5 = UserInputNum();
			int num6 = UserInputNum();
			System.out.println();
			
			System.out.println("Multiplication is : "+(num5*num6));
			break;

		case '/' :
			
			int num7 = UserInputNum();
			int num8 = UserInputNum();
			System.out.println();
			
			if(num8==0) {
				System.out.println("Error Divide By 0....!");
				break;
			}
			System.out.println("Division is : "+(num7/num8));
			break;

		case '%' :
			
			int num9 = UserInputNum();
			int num10 = UserInputNum();
			System.out.println();
			
			System.out.println("Modulo is : "+(num9%num10));
			break;
			
		default :
			System.out.println();
			
			System.out.println("Unknown Operator....");
		}
	}
}