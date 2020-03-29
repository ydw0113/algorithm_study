package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q1017 {
	static int n;
	static int map[];
	static boolean visited[];
	static ArrayList<Integer> answer = new ArrayList<>();
	static ArrayList<Integer> li = new ArrayList<>();
	static ArrayList<Integer> list[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int an[] = new int[n + 1];
		map = new int[1001];
		int arr[][] = new int[n + 1][n + 1];
		list = new ArrayList[1001];
		visited = new boolean[1001];
		for (int i = 1; i <= n; i++) {
			an[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				arr[i][j] = an[i] + an[j];
				// System.out.print(arr[i][j] + " ");
			}
			// System.out.println();
		}
		int cnt;
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
			for (int j = 1; j <= n; j++) {
				cnt = 0;
				if (arr[i][j] == 0)
					continue;
				for (int z = 2; z < arr[i][j]; z++) {
					if (arr[i][j] % z == 0) {
						cnt++;
					}
				}
				if (cnt == 0) {
					if (i == 1)
						answer.add(an[j]);
					list[i].add(an[j]);
				}
			}

		}

		int count = 1;
		for (int a : answer) {
			Arrays.fill(map, 0);
			count = 1;
			for (int i = 2; i <= n; i++) {
				Arrays.fill(visited, false);
				map[a] = 1;
				visited[a] = true;
				if (dfs(i)) {
					count++;
				}
			}
			if (count == n)
				li.add(a);
		}
		if (li.size() < 1) {
			System.out.println(-1);
		} else {

			Collections.sort(li);
			for (int i : li)
				System.out.print(i + " ");
		}
		sc.close();
	}

	public static boolean dfs(int x) {
		int size = list[x].size();
		for (int i = 0; i < size; i++) {
			int tmp = list[x].get(i);
			if (visited[tmp])
				continue;
			visited[tmp] = true;
			if (map[tmp] == 0 || dfs(map[tmp])) {
				map[tmp] = x;
				return true;
			}
		}
		return false;
	}
}
