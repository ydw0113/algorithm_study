package study;

import java.util.Scanner;

public class Q11057 {
	static int n, answer;
	static boolean visited[] = new boolean[10];
	static int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int copy[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		answer = 0;
		if (n == 1)
			answer = 10;
		else {
			for (int i = 0; i < n; i++) {
				
			}
		}

	}

	public static void solve(int start, int depth) {
		if (depth == n) {

		} else {
			for (int i = start; i < n * 10; i++) {
				int x = i % 10;

			}

		}

	}

}
