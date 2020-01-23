import java.util.Scanner;

public class DpQ2631 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i,n = sc.nextInt();
		int[] a = new int[n];
		int[] dp = new int[n];
		int max = 0;
		dp[0] = 1;
		for (i = 0; i < n; ++i)
			a[i] = sc.nextInt();
		for (i = 1; i < n; ++i) {
			dp[i] = 1;
			for (int j = 0; j < i; ++j) {
				if (a[i] > a[j] && dp[j] + 1 > dp[i])
					dp[i] = dp[j] + 1;
			}
			if (max < dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
}
