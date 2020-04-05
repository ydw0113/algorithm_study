package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1733 {
	static int dist[];
	static int n, m;
	static boolean visited[];
	static int arr[];
	static ArrayList<Integer> list[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[1000010];
		dist = new int[1000010];
		visited = new boolean[1000010];
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[i].add(a);
			list[i].add(b);

		}

		Arrays.fill(arr, 0);
		for (int i = 1; i <= n; i++) {
			Arrays.fill(visited, false);
			dfs(i);
			if (sb.length() == n)
				break;
		}
		if (sb.length() < n)
			System.out.print(-1);
		else
			System.out.print(sb);
	}

	public static boolean dfs(int x) {
		if(x==-1) return true;
		int size = list[x].size();
		for (int i = 0; i < size; i++) {
			int tmp = list[x].get(i);
			if (visited[tmp])
				continue;
			visited[tmp] = true;
			if (dfs(arr[tmp])) {
				sb.append(tmp + "\n");
				dist[tmp] = x + 1;
				arr[tmp] = x;
				return true;
			}
		}
		return false;
	}

}
