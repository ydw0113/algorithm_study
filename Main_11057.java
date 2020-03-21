package study;

import java.util.Scanner;

public class Main_11057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[10];

		for (int i = 0; i < 10; i++)
			dp[i] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < 10; j++) {
				dp[j] = (dp[j] + dp[j - 1]) % 10007;
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++)
			sum += dp[i];
		System.out.println(sum % 10007);
		sc.close();
	}

}
