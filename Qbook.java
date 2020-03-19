package study;

import java.util.Scanner;
import java.util.Stack;

public class Qbook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int count = 1;
		int max = 0;
		int flag = 0;
		Stack<Integer> s = null;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		if (arr[0] < arr[1])
			flag = 1;
		else if (arr[0] > arr[1]) {
			flag = 0;
		}
//		s.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (flag == 1) {
				if (arr[i - 1] > arr[i]) {
					flag = 0;
					count++;
				}
			} else if (flag == 0) {
				if (arr[i - 1] < arr[i]) {
					flag = 1;
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
