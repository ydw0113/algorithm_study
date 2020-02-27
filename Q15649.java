package study;

import java.util.LinkedList;
import java.util.Scanner;

public class Q15649 {
	static int n, m;
	static int arr[];
	static LinkedList<Integer> q = new LinkedList<Integer>();
	static boolean visited[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;
		solve(0);
	}

	public static void solve(int depth) {
		if (depth == m) {
			for (int i : q) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					q.add(arr[i]);
					solve(depth + 1);
					visited[i] = false;
					q.removeLast();
				}
			}
		}
	}

}
