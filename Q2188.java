package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2188 {

	static int n, m;
	static boolean visited[];
	static int arr[];
	static ArrayList<Integer> list[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[201];
		visited = new boolean[201];
		list = new ArrayList[201];
		int y;
		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			String word[] = s.split(" ");
			list[i] = new ArrayList<Integer>();
			for (int j = 1; j < word.length; j++) {
				y = Integer.parseInt(word[j]);
				list[i].add(y);
			}
		}
		Arrays.fill(arr, 0);
		int count = 0;
		for (int i = 1; i <= n; i++) {
			Arrays.fill(visited, false);
			if (dfs(i))
				count++;
		}
//		for (int i = 1; i <= n; i++) {
//			if (arr[i] != 0)
//				System.out.println(arr[i]);
//		}
		System.out.println(count);
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
