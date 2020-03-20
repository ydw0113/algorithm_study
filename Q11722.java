package study;

import java.util.Scanner;

public class Q11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n + 1];
		int dp[] = new int[n + 1];
		int tmp;
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (	arr[i] < arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= n; i++)
			max = Math.max(dp[i], max);
		System.out.println(max);
		sc.close();
	}

}
