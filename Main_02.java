package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_02 {
	static List<Integer>[] list;
	static boolean[] visit;
	static int n, m, count = 0;
	static ArrayList<Integer> li = new ArrayList<>();

	private static void dfs(int v, int c) {

		for (int i : list[v]) {
			if (i == c) {
				count++;
				continue;
			} else {
				dfs(i, c);
				System.out.println(i);
				count++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			list[i] = new ArrayList<>();

		visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			int a = scan.nextInt();
			list[a].add(i);
		}
		for (int i = 0; i < m; i++) {
			li = new ArrayList<>();
			int a = scan.nextInt();
			int b = scan.nextInt();
			dfs(a, b);
		}
		System.out.println(count);

	}
}