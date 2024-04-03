package Mini_Projects;

import java.util.Scanner;

class Calculate {
	public static void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("+++++++++Enter Choice+++++++++++ ");
		System.out.println("(1) -> Sqaure");
		System.out.println("(2) -> circle");
		System.out.println("(3) -> Rectangle");
		System.out.println("(4) -> Cone");
		System.out.println("(5) -> Triagle");
		System.out.println("(6) -> PentaGone");
		System.out.println("(7) -> HexaGone");
		System.out.println("(8) -> Cube");
		int choice = sc.nextInt();
		Choice(choice);
	}

	public static void Choice(int choice) {
		switch (choice) {
		case 1:
			square();
			break;
		case 2:
			circle();
			break;
		case 3:
			Rectangle();
			break;
		case 4:
			Cone();
			break;
		case 5:
			Triagle();
			break;
		case 6:
			PentaGone();
			break;
		case 7:
			HexaGone();
			break;
		case 8:
			Cube();
			break;

		default:
			System.out.println("Invalid choice\n try Again \n");
			Input();
		}
	}

	private static void Cube() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter side : ");
		int side = sc.nextInt();
		 System.out.println("Area of Cube : "+(side*side*side));

	}

	private static void HexaGone() {
//		  double sideLength = 5.0; 
//		double area = (3 * Math.sqrt(3) / 2) * Math.pow(sideLength, 2);
		System.out.println("Sorry Currently UnAvaiable");
		Input();
	}

	private static void PentaGone() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Length of Side : ");
		float sideLength = sc.nextFloat();
		float area = (float) ((float)(5 * Math.pow(sideLength, 2)) / (4 * Math.tan(Math.PI / 5)));
		System.out.println("Area of PentaGone : "+area);
	}

	private static void Triagle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Base : ");
		int base = sc.nextInt();
		System.out.print("Enter Height : ");
		int height = sc.nextInt();
		System.out.println("Area Of Triangle : "+(base * height) / 2);
	}

	private static void Rectangle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Lenght : ");
		int l = sc.nextInt();
		System.out.print("Enter width : ");
		int w = sc.nextInt();
		System.out.println("Area Of Triangle : "+(l*w));
	
	}

	private static void circle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Radius : ");
		int r = sc.nextInt();
		float result =(float) ((Math.PI)*(r*r));
		System.out.println("Area of Circle : "+(result));
	}

	private static void square() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Side : ");
		int side = sc.nextInt();
		System.out.println("Area of Sqaure : "+(side*side));
	}

	private static void Cone() {
		System.out.println("Sorry Currently UnAvaiable");
		Input();
	}

}

public class AreaOfShape {

	public static void main(String[] args) {
		Calculate.Input();
	}
}