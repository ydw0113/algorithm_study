package study;

import java.util.Arrays;
import java.util.Scanner;

public class Q1654 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		long left = 1;
		long right = arr[n];
		long mid;
		while (left <= right) {
			mid = (left + right) / 2;
			long sum = 0;
			for (int i = 1; i <= n; i++)
				sum += arr[i] / mid;

			if (sum >= k) {
				left = mid + 1;
			} else if (sum < k) {
				right = mid - 1;
			}
		}
		System.out.println(right);
		sc.close();

	}

}
