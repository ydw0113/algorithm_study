package study;

import java.util.Arrays;
import java.util.Scanner;

public class Q15657 {
	static int n, m;
	static int arr[], answer[];
	static StringBuilder s = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		answer = new int[m];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		solve(m, 0, 0);
		System.out.println(s);
	}

	public static void solve(int r, int index, int depth) {
		if (r == 0) {
			for (int i : answer) {
				s.append(i + " ");
			}
			s.append("\n");
			return;
		}

		if (depth == n)
			return;
		answer[index] = arr[depth];
		solve(r - 1, index + 1, depth);
		solve(r, index, depth + 1);

	}
}
