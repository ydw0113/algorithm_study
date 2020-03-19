package study;

import java.util.Scanner;

public class Q2661 {

	public static final int START = 1;
	public static final int END = 3;

	public static int len;
	public static int[] arr;
	public static boolean is_end = false;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		len = sc.nextInt();

		arr = new int[len];

		backtracking("");
	}

	public static void backtracking(String str) {
		if (is_end)
			return;

		if (str.length() == len) {
			System.out.println(str);
			is_end = true;

			return;
		}

		for (int i = START; i <= END; i++) {
			if (isAble(str + i)) {
				backtracking(str + i);
			}
		}
	}

	public static boolean isAble(String str) {
		int len = str.length();
		// 1212 가 들어올 경우
		// 한글자씩 비교 했을 경우에는 유효하지만
		// 두글자씩 비교 했을 경우에는 12 12 가 같으므로 유효하지 않다.
		for (int i = 1; i <= len / 2; i++) {
			String front_str = str.substring(str.length() - i - i, str.length() - i);
			String behind_str = str.substring(str.length() - i, str.length());

			if (front_str.equals(behind_str))
				return false;
		}

		return true;
	}
}
