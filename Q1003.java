package study;

import java.util.*;

public class Q1003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			for (int j = 0; j <= a; j++) {
				if (a == j) {
					System.out.printf("%d %d\n", fib0(j), fib1(j));
				} else {
					fib0(j);
					fib1(j);
				}
			}
		}
	}

	static int fib0(int n) {
		if (n == 0)
			return 1;
		else if (n == 1)
			return 0;
		else
			return fib0(n - 1) + fib0(n - 2);
	}

	static int fib1(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib1(n - 1) + fib1(n - 2);
	}

}
