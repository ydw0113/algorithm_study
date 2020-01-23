import java.util.Scanner;

public class DpQ2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i, n = sc.nextInt();
		int a[] = new int[n + 1];
		int dp[] = new int[n + 1];
		for (i = 1; i <= n; i++)
			a[i] = sc.nextInt();

		dp[1] =a[1];
		dp[2] =a[1]+a[2];
		for (i = 3; i <= n; i++) {
			dp[i]=Math.max(dp[i-2]+a[i], dp[i-3]+a[i-1]+a[i]);
		}
		System.out.println(dp[n]);
	}

}
