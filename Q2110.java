package study;

import java.util.Arrays;
import java.util.Scanner;

public class Q2110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int left = arr[0];
		int right = arr[n - 1];
		int mid;
		long max = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			long start = arr[0];
			long count = 1;

			for (int i = 0; i < n; i++) {
				if (arr[i] - start >= mid) {
					count++;
					start = arr[i];
				}
			}
			System.out.println(left + " " + right + " " + mid);

			if (count >= c) {
				max = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(max);
		sc.close();
	}

}
