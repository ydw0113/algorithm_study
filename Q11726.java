package study;

import java.util.Scanner;

public class Q11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 1; i <= n; i++) {
			for (int j = 3; j <= i; j++) {
				if (j % 2 == 0) {
					dp[i] += dp[i - 2*j] * 2;
				} else
					dp[i] += dp[i - j];
			}
			System.out.println(dp[i]);
		}
		System.out.println(dp[n]);

		sc.close();
	}

}
