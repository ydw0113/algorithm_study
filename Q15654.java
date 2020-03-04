package study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Q15654 {
	static int n, m;
	static int arr[];
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static boolean visited[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		solve(0);
	}

	private static void solve(int depth) {
		if (depth == m) {
			for (int a : list) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					list.add(arr[i]);
					solve(depth + 1);
					visited[i] = false;
					list.removeLast();
				}

			}
		}
	}

}
