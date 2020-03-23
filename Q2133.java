package study;

import java.util.Scanner;

public class Q2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n + 1];
		if (n % 2 == 0) {
			dp[2] = 3;
			dp[0] = 1;
			for (int i = 4; i <= n; i += 2) {
				for (int j = 2; j <= i; j += 2) {
					int tmp = j == 2 ? 3 : 2;
					dp[i] += tmp * dp[i - j];
				}
			}
		} else
			dp[n] = 0;
		System.out.println(dp[n]);
	}

}
