package study;

import java.util.*;

public class Q1904 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d[] = new int[n + 1];
		d[0] = 0;
		d[1] = 1;
		d[2] = 2;
		for (int i = 3; i <= n; i++) {
			d[i] = d[i - 2] + d[i - 1];
			d[i] %= 15746;
		}
		System.out.println(d[n]);
		sc.close();
	}
}