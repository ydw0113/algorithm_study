package study;

import java.util.Arrays;
import java.util.Scanner;

public class Q5052 {
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i])) {
				answer = false;
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			String phone_book[] = new String[n];
			for (int i = 0; i < n; i++) {
				phone_book[i] = sc.next();
			}
			if (solution(phone_book))
				System.out.println("YES");
			else
				System.out.println("NO");
			t--;
		}
	}
}