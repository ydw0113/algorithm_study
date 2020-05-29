package study;

import java.util.Scanner;

public class Q2003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		int answer = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int i = 0, j = 0;
		while (i < n && j < n) {
			if (i == j) {
				if (arr[i] == m) {
					answer++;
					i++;
					j = i;
					sum = 0;
				} else if (arr[i] > m) {
					i++;
					j = i;
					sum = 0;
				} else {
					sum += arr[i];
					j++;
				}
			} else if (sum + arr[j] == m) {
				i++;
				answer++;
				j = i;
				sum = 0;
			} else if (sum + arr[j] > m) {
				i++;
				j = i;
				sum = 0;

			} else {
				sum += arr[j];
				j++;
			}
			System.out.println(i + " " + j + " " + sum);
		}
		System.out.println(answer);
		sc.close();
	}
	

}
