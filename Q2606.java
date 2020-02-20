package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2606 {
	static int n, m;
	static int arr[][];
	static boolean visited[];
	static int count = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = 1;
		}
		bfs(1);
		System.out.println(count);
	}

	public static void bfs(int k) {
		count = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(k);
		while (!q.isEmpty()) {
			int x = q.poll();
			visited[x] = true;
			for (int i = 1; i <= n; i++) {
				if (arr[x][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					count++;
				}
			}
		}
	}
}