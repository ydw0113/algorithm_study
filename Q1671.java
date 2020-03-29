package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1671 {

	static int n;
	static boolean visited[];
	static int arr[];
	static ArrayList<Integer> list[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int sh[][] = new int[n + 1][3];
		arr = new int[1001];
		visited = new boolean[1001];
		list = new ArrayList[1001];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			sh[i][0] = a;
			sh[i][1] = b;
			sh[i][2] = c;
		}
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (sh[i][0] == sh[j][0] && sh[i][1] == sh[j][1] && sh[i][2] == sh[j][2] && i < j)
					continue;
				if (sh[i][0] >= sh[j][0] && sh[i][1] >= sh[j][1] && sh[i][2] >= sh[j][2]) {
					list[i].add(j);
				}
			}
		}
		Arrays.fill(arr, 0);
		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 2; j++) {
				Arrays.fill(visited, false);
				if (dfs(i))
					count++;
			}
		}
		System.out.println(n - count);
	}

	public static boolean dfs(int x) {
		int size = list[x].size();
		for (int i = 0; i < size; i++) {
			int tmp = list[x].get(i);
			if (visited[tmp])
				continue;
			visited[tmp] = true;
			if (arr[tmp] == 0 || dfs(arr[tmp])) {
				arr[tmp] = x;
				return true;
			}
		}
		return false;
	}

}
