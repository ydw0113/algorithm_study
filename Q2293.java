package study;

import java.util.Scanner;

public class Q2293 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		int dp[] = new int[10001];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i]; j <= k; j++) {
				dp[j] += dp[j - arr[i]];
			}
		}
		System.out.println(dp[k]);

	}

}
