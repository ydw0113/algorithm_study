package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Q12865 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		int arr2[] = new int[n];
		int sum = 0;
		boolean flag = false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int dp[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			map.put(arr[i], sc.nextInt());
		}

		Arrays.sort(arr);
		int index = 0;
		for (int i = 0; i < n; i++) {
			arr2[i] = map.get(arr[i]);
			if (!flag && i > 0) {
				sum = arr[i] + arr[i - 1];
				if (sum > k) {
					index = i;
					flag = true;
				}
			}
		}
		for(int i=0; i<n; i++)
			System.out.println(arr[i]+" "+arr2[i]);
		dp[0] = arr2[0];
		int max = arr2[0];
		for (int i = 1; i < n; i++) {
			if (i < index) {
				if (arr[i] + arr[i - 1] > k) {
					dp[i] = Math.max(dp[i - 1], arr2[i]);
				} else
					dp[i] = Math.max(dp[i - 1] + arr2[i], arr2[i]);
			} else
				dp[i] = arr2[i];
			System.out.print(dp[i] + " ");
			max = Math.max(dp[i], max);
		}
		System.out.println(max);

	}

}
