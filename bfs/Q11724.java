package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11724 {
	static int n,count=0,result=0;;
	static int m;
	static boolean visited[];
	static int arr[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[1001][1001];
		visited = new boolean[1001];

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
			dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}

	public static void dfs(int next) {
		visited[next] = true;
		for (int i = 1; i <= n; i++) {
			if (arr[next][i] == 1 && !visited[i]) {
				dfs(i);
				count++;
			}
		}
	}

}
