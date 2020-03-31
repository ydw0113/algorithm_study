package study;

import java.util.Arrays;
import java.util.Scanner;

public class Q10815 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n + 1];
		int left;
		int right;
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int m = sc.nextInt();
		int arr2[] = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			arr2[i] = sc.nextInt();
		}

		for (int i = 1; i <= m; i++) {
			left = 0;
			right = n;
			boolean flag = false;

			while (left <= right) {
				int mid = (left + right) / 2;
				if (arr[mid] < arr2[i]) {
					left = mid + 1;
				} else if (arr[mid] > arr2[i]) {
					right = mid - 1;
				} else {
					flag = true;
					break;
				}

			}
			if (flag)
				sb.append(1 + " ");
			else
				sb.append(0 + " ");
		}
		System.out.print(sb);
		sc.close();
	}

}
