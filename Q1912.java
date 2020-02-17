package study;

import java.util.Scanner;

public class Q1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int dp[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		dp[0] = arr[0];
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			System.out.print(dp[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
