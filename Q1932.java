package study;

import java.util.Scanner;

public class Q1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		int dp[][] = new int[n][n];
		int max = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				dp[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + dp[i][j];
				}
				if (sum < dp[i][j])
					sum = dp[i][j];
			}
		}
		System.out.println(sum);

	}

}
