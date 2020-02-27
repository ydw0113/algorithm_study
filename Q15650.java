package study;

import java.util.LinkedList;
import java.util.Scanner;

public class Q15650 {
	static int n, m;
	static int arr[];
	static int answer[];
	static boolean visited[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n + 1];
		answer = new int[m];
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;
		solve(m, 0, 0);
	}

	public static void solve(int r, int index, int depth) {
		if (r == 0) {
			for (int i : answer) {
				System.out.print(i+1 + " ");
			}
			System.out.println();
			return;
		}
		if (depth == n)
			return;
		answer[index] = depth;
		solve(r - 1, index + 1, depth);
		solve(r, index, depth + 1);
	}

}
