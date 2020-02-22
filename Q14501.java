package study;

import java.util.Scanner;

public class Q14501 {
	static int n, arr[][], dp[];
	static boolean visited[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		arr = new int[n + 1][2];
		dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			dp[i] = arr[i][1];
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (i - j >= arr[j][0]) {
					dp[i] = Math.max(dp[j] + arr[i][1], dp[i]);
				}
			}

		}
		for (int i = 1; i <= n; i++) {
			if (i + arr[i][0] <= n + 1) {
				max = Math.max(dp[i], max);
			}
		}
		System.out.println(max);

	}

}
