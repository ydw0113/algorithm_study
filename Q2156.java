package study;

import java.util.Scanner;

public class Q2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int dp[] = new int[n];
		int count = 1;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		if (n >= 1) {
			dp[0] = arr[0];
		}
		if (n >= 2) {
			dp[1] = arr[0] + arr[1];
		}
		if (n >= 3) {
			dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));
		}
		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
		}
		int max = 0;
		for (int i = 0; i < dp.length; i++)
			max = Math.max(max, dp[i]);
		System.out.println(max);
	}

}
