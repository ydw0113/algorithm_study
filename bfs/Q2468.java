package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {
	static int n, count = 0;
	static int arr[][];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int h=0;
		for (int i = 0; i < n; i++) {
			h++;
			for (int j = 0; j < n; j++) {
				if (arr[i][j] > h) {
					dfs(i, j, h);
					System.out.println(i + "   " + j);
					count++;
				}
			}
		}
		System.out.println(count);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}

	}

	public static void dfs(int x, int y, int h) {
		// count++;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = x + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
				continue;
			}
			if (arr[nextX][nextY] <= h || visited[nextX][nextY])
				continue;
			visited[nextX][nextY] = true;
			dfs(nextX, nextY, h);
		}
	}

}
