package study;

import java.util.Scanner;

public class Q11055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int dp[] = new int[n];
		int sum = 0, tmp;
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp[i]=arr[i];
		}
		max = dp[0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
					dp[i] = dp[j] + arr[i];
				}
			}
		}
		for (int i = 1; i < dp.length; i++) {
//			System.out.println(dp[i]);
			max = Math.max(dp[i], max);
		}

		System.out.println(max);
	}

}
