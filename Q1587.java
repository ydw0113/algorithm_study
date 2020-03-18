package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1587 {

	static int n, k;
	static boolean visited[];
	static int arr[];
	static ArrayList<Integer> list[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n];
		visited = new boolean[n];
		list = new ArrayList[n];

		for (int i = 0; i < n; i++)
			list[i] = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
		}

		Arrays.fill(arr, -1);

		for (int i = 0; i < n; i++) {
			Arrays.fill(visited, false);
			// System.out.println(dfs(i));
			if (!dfs(i)) {
				System.out.println("X");
				flag=false;
				break;
			} else {
				flag = true;
			}
		}
		if (flag) {
			System.out.println("O");
		}
		// 매칭 된 간선
		// for (int i = 0; i < n; i++) {
		// if (arr[i] != -1)
		// System.out.println(arr[i]);
		// }
		sc.close();
	}

	public static boolean dfs(int x) {
		int size = list[x].size();
		for (int i = 0; i < size; i++) {
			int tmp = list[x].get(i);
			// System.out.println(tmp);
			if (visited[tmp])
				continue;
			visited[tmp] = true;
			if (arr[tmp] == -1 || dfs(arr[tmp])) {
				arr[tmp] = x;
				return true;
			}
		}
		return false;
	}

}
