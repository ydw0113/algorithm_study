package study;

import java.util.Scanner;

public class Q13456 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n, b, c;
		long arr[], answer[];
		n = sc.nextInt();
		arr = new long[10000001];
		answer = new long[10000001];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		long sum = n;
		for (int i = 0; i < n; i++) {
			if (arr[i] > b)
				arr[i] -= b;
			else
				continue;
			if (arr[i] % c > 0)
				answer[i] = arr[i] / c + 1;
			else
				answer[i] = arr[i] / c;
			sum += answer[i];
		}
		System.out.println(sum);
	}

}
