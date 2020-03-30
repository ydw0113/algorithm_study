package study;

import java.util.Scanner;

public class Q2805 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n + 1];
		int left = 0;
		int right = 0;
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			right = Math.max(right, arr[i]);
		}
		int max = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for (int i = 1; i <= n; i++) {
				if (arr[i] < mid)
					continue;
				sum += arr[i] - mid;
			}
			if (sum >= m) {
				max = Math.max(mid, max);
				left = mid + 1;
			} else if (sum < m) {
				right = mid - 1;
			}
		}
		System.out.println(max);
		sc.close();
	}

}
