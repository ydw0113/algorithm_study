package study;

import java.util.Scanner;

public class Q9251 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String s2 = sc.next();
		String arr[], arr2[];
		arr = s.split("");
		arr2 = s2.split("");
		int dp[][] = new int[arr.length + 1][arr2.length + 1];
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= arr2.length; j++) {
				if (arr[i - 1].equals(arr2[j - 1])) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[arr.length][arr2.length]);
	}

}
