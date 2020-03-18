package study;

import java.util.Scanner;

public class Q2220 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n + 1];
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 1; j /= 2) {
				System.out.println(i+"  "+j+"  "+a[j]+"  "+a[j/2]);
				a[j] = a[j / 2];
				
			}
			a[1] = i + 1;
		}
		a[n] = 1;
		for (int i = 1; i <= n; i++)
			System.out.print(a[i] + " ");
	}

}
