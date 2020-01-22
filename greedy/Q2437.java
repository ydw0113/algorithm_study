package study;

import java.util.Arrays;
import java.util.Scanner;

public class Q2437 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}

		Arrays.sort(a);

		int min = 1;
		for (int i = 0; i < n; i++) {
			if (min < a[i]) {
				break;
			}
			min += a[i];
		}
		System.out.println(min);
	}

}
