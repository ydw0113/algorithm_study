package study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Q1021 {
	static LinkedList<Integer> dq = new LinkedList<Integer>();
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[m];
		for (int i = 0; i < m; i++)
			arr[i] = sc.nextInt();
		for (int i = 1; i <= n; i++)
			dq.add(i);

		for (int i = 0; i < arr.length; i++) {
			solve(arr[i]);
		}
		System.out.println(count);

	}

	private static void solve(int num) {
		while (true) {
			int size = dq.size();
			int pos = dq.indexOf(num);
			int left = pos;

			int right = size - pos - 1;

			if (left == 0) {
				dq.remove(pos);
				break;
			}
			if (left <= right) {
				dq.addLast(dq.removeFirst());
				count++;
			} else {
				dq.addFirst(dq.removeLast());
				count++;
			}
		}
	}

}
