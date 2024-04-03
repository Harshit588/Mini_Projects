package Mini_Projects;

import java.util.function.Supplier;

public class OTPGenerator {

	public static void main(String[] args) throws InterruptedException {

		Supplier<String> Otp = () -> {
			String otp4 = "";
			for (int i = 1; i <= 6; i++) {
				otp4 += (int) (Math.random() * 10);
			}
			return otp4;
		};
		
		System.out.println(Otp.get());
	}
}
