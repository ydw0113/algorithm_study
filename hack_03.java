package study;

public class hack_03 {
	static int count = 0;

	public static int solution(int n, int m, int k) {
		int answer = 0;
		long[][] dp = new long[201][201];
		boolean flag = false;
		if (n % 2 == 0) {
			flag = true;
		}
		for (int i = 1; i <= m / 2; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n / 2; i++) {
			dp[i][1] = 0;
			for (int j = 2; j <= m / 2; j++)
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
		}
		if (flag)
			System.out.println(dp[n / 2][m / 2] * 2 % 1000000007);
		else {
			long sum = 0;
			sum += dp[n / 2][m / 2];

			for (int i = 0; i <= m / 2; i++) {
				dp[1][i] = 1;
			}

			for (int i = 2; i <= n / 2 + 1; i++) {
				dp[i][0] = 1;
				for (int j = 1; j <= m / 2; j++)
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
			}

			sum = sum + (dp[n / 2 + 1][m / 2] % 1000000007);
			System.out.println(sum);
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 50;
		int m = 150;
		int k = 20;
		solution(n, m, k);
	}
}
