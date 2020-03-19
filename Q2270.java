package study;

import java.util.*;

public class Q2270 {

	static Scanner input = new Scanner(System.in);
	static int n, a, b, c, i, count = 0, j;
	static int mod = 1000000;
	static int[] arr;
	static int[] pow = new int[100001];

	public static void main(String[] args) {
		n = input.nextInt();
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		arr = new int[n + 1];
		arr[0] = 0;

		pow[0] = 1;
		for (i = 1; i < 100001; i++) {
			pow[i] = (pow[i - 1] * 2) % mod;
		}

		for (i = 1; i <= a; i++) {
			arr[input.nextInt()] = 1;
		}
		for (i = 1; i <= b; i++) {
			arr[input.nextInt()] = 2;
		}
		for (i = 1; i <= c; i++) {
			arr[input.nextInt()] = 3;
		}
		System.out.println(arr[n]);
		hanoi(n - 1, arr[n]);
		System.out.println(count);
	}

	public static void hanoi(int num, int to) {
		int from = arr[num];
		int by = 6 - from - to;
		if (num < 1)
			return;
		if (to != from) {
			hanoi(num - 1, by);
			count = (count + pow[num - 1]) % mod;
		} else {
			hanoi(num - 1, to);
		}
	}

}