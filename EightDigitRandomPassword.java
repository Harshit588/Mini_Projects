package Mini_Projects;

import java.util.function.Supplier;

public class EightDigitRandomPassword {
	public static void main(String[] args) {

		Supplier<Integer> numerical = () -> ((int) (Math.random() * 10));

		Supplier<Character> charValve = () -> {

			return "abcdefghijklmnopqrstuvwxyz@#$&".charAt((int) (Math.random() * 30));
		};

		Supplier<String> passward = () -> {

			String pass = "";
			for (int i = 1; i <= 8; i++) {
				if (i % 2 == 0) {
					pass += numerical.get();
				} else {
					pass += charValve.get();
				}
			}
			return pass;
		};

		System.out.println(passward.get());
		System.out.println(passward.get());
		System.out.println(passward.get());
		System.out.println(passward.get());
		System.out.println(passward.get());
		System.out.println(passward.get());
		System.out.println(passward.get());
		System.out.println(passward.get());
	}
}
