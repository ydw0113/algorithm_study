package study;

import java.util.Scanner;

public class lms_01 {
	static int n, k;
	static int[] arr, ticket;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[1010];
		ticket = new int[20];
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			int tmpIndex = MIN();
			ticket[tmpIndex] += arr[i];
			if (ticket[tmpIndex] > max) {
				max = ticket[tmpIndex];
			}
		}
		System.out.println(max);
		sc.close();
	}

	public static int MIN() {
		int min = ticket[0];
		int index = 0;
		for (int i = 1; i < k; i++) {
			if (min > ticket[i]) {
				min = ticket[i];
				index = i;
			}
		}
		return index;
	}

}
