package study;

import java.util.Scanner;

public class Q3079 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		long max = 0;
		long arr[] = new long[(int)n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			max=Math.max(max, arr[i]);
		}
		long left = 1;
		long right = max*m;
		
		long mid;
		long answer = right;
		while (left <= right) {
			mid = (left + right) / 2;
			System.out.println(mid);
			int sum = 0;
			for (int i = 0; i < arr.length; i++)
				sum += mid / arr[i];
			System.out.println(sum);
			if (sum >= m) {
				answer = Math.min(mid, answer);
				right = mid - 1;
			} else
				left = mid + 1;

		}
		System.out.println(answer);
		sc.close();
	}

}
