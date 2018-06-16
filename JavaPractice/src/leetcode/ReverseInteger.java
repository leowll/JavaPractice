package leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		int result = reverse(-99991);
		System.out.println(result);
	}

	public static int reverse(int x) {
		int result = 0;

		while (x != 0) {
			result = result * 10 + x % 10;
			if (x >= Integer.MAX_VALUE)
				return 0;
			if (x <= Integer.MIN_VALUE)
				return 0;
			x = x / 10;
		}

		return result;

	}
}
