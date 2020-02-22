package study;

import java.util.Scanner;

public class Q1977 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int min = 100000000;
		int d = 1;
		int i;
		int sum = 0;
		while (true) {
			i = (int) Math.pow(d, 2);
			if (n <= i && m >= i) {
				min = Math.min(min, i);
				sum += i;
			}
			d++;
			if (m < i)
				break;
		}
		if (min == 100000000)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
