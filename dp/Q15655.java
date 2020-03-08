package study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Q15655 {
	static int n, m;
	static int arr[], answer[];
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static boolean visited[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		answer = new int[m];
		visited = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		solve(m, 0, 0);
	}

	private static void solve(int r, int index, int depth) {
		if (r == 0) {
			for (int a : answer) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		} else {
			if (depth == n)
				return;
			System.out.println(r +" "+index+" "+arr[depth]);
			answer[index] = arr[depth];
			solve(r - 1, index + 1, depth+1);
			solve(r, index, depth + 1);
		}
	}

}
