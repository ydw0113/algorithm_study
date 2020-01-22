package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2583 {
	static int n, m, k, count = 0, count2 = 0;
	static int arr[][];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int a = x; a < x2; a++) {
				for (int b = y; b < y2; b++) {
					visited[b][a] = true;
					arr[b][a] = -1;
				}
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					dfs(i, j, 1);
					count++;
					if (count2 > 0)
						pq.add(count2);
					count2 = 0;
				}
			}
		}
		System.out.println(count);
		while(!pq.isEmpty())
			System.out.print(pq.poll()+" ");
		
	}

	public static void dfs(int x, int y, int depth) {
		arr[x][y] = 1;
		visited[x][y] = true;
		count2++;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
				continue;
			}

			if (arr[nextX][nextY] == -1 || visited[nextX][nextY])
				continue;
			visited[nextX][nextY] = true;
			dfs(nextX, nextY, depth + 1);
		}
	}

}
