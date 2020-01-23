package algori;

import java.util.Scanner;

public class Q1182 {
	static int n, s, arr[], sum = 0, count = 0, answer[];
	static boolean visited[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];
		answer = new int[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		for (int i = 1; i <= n; i++)
			solve(0, 0, i);

		System.out.println(count);
	}

	public static void solve(int next, int depth, int r) {
		if (depth == r) {
			// print(r);
			sum(r);
			return;
		} else {
			for (int i = next; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					answer[depth] = arr[i];
					solve(i + 1, depth + 1, r);
					visited[i] = false;
				}

			}
		}
	}

	static void print(int r) {
		for (int i = 0; i < r; i++)
			System.out.print(answer[i] + " ");
		System.out.println();
	}

	static void sum(int r) {
		int sum = 0;
		for (int i = 0; i < r; i++)
			sum += answer[i];
		if (sum == s)
			count++;
//		System.out.println(sum);
	}

}
