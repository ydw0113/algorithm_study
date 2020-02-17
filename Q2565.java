package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Q2565 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int arr[] = new int[n + 1];
		int arr2[] = new int[n + 1];
		int dp[] = new int[n + 1];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			map.put(arr[i], sc.nextInt());
		}
		Arrays.sort(arr);
		for (int i = 1; i <= n; i++) {
			arr2[i] = map.get(arr[i]);
		}
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (map.containsKey(arr[j])) {
					if (arr2[i] > arr2[j] && dp[i] <= dp[j])
						dp[i] = dp[j] + 1;
					else if (arr2[i] == arr2[j])
						dp[i] = dp[j];
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= n; i++)
			max = Math.max(dp[i], max);

		System.out.println(n - max);

	}

}
