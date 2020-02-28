package study;

import java.util.LinkedList;
import java.util.Scanner;

public class Q15651 {
	static int n, m;
	static int arr[];
	static LinkedList<Integer> q = new LinkedList<Integer>();
	static StringBuilder sb;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n + 1];
		sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;
		solve(0);
		System.out.print(sb.toString());
	}

	public static void solve(int depth) {
		if (q.size() == m) {
			for (int i : q) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		} else {
			for (int i = 0; i < n; i++) {
				q.add(arr[i]);
				solve(depth + 1);
				q.removeLast();
			}
		}
	}

}
