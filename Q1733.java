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
		arr = new int[1000001];
		dist = new int[1000001];
		visited = new boolean[1000001];
		list = new ArrayList[n + 1];
		int y;
		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			String word[] = s.split(" ");
			list[i] = new ArrayList<Integer>();
			for (int j = 0; j < word.length; j++) {
				y = Integer.parseInt(word[j]);
				list[i].add(y);
			}
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
		int size = list[x].size();
		for (int i = 0; i < size; i++) {
			int tmp = list[x].get(i);
			if (visited[tmp])
				continue;
			visited[tmp] = true;
			if (arr[tmp] == 0 || dist[tmp] == dist[x] + 1 && dfs(arr[tmp])) {
				sb.append(tmp + "\n");
				dist[tmp] = x + 1;
				arr[tmp] = x;
				return true;
			}
		}
		return false;
	}

}
