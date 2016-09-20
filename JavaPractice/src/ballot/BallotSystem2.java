package ballot;

import java.util.Random;

public class BallotSystem2 {

	public static String pick() {
		Random random = new Random();
		int n = (int) random.nextInt(100);
		System.out.println(n);
		if (n >= 0 && n < 5) {
			return "‘å‹g";
		} else if (n > 5 && n < 20) {
			return "’†‹g";
		} else if (n >= 20 && n < 85) {
			return "¬‹g";
		} else {
			return "‹¥";
		}
	}

	public static void main(String[] args) {
		String lot = pick();
		System.out.println(lot);
	}

}
