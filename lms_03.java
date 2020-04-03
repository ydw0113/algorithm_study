package study;

import java.util.Scanner;

public class lms_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[160];
		int start;
		int end;
		int max = 0;
		for (int i = 0; i < n; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			for (int j = start; j < end; j++) {
				arr[j]++;
				max=Math.max(max, arr[j]);
			}
		}
		System.out.println(max);

		sc.close();

	}
}
