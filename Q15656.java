package study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Q15656 {
	static int n, m;
	static int arr[];
	static StringBuilder s = new StringBuilder();
	static LinkedList<Integer> list = new LinkedList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		solve(0);
		System.out.println(s);
	}

	public static void solve(int depth) {
		if (depth == m) {
			for (int i : list) {
				s.append(i + " ");
			}
			s.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			list.add(arr[i]);
			solve(depth + 1);
			list.removeLast();
		}
	}

}
