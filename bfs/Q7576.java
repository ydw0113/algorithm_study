package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
	static int n, m;
	static int[][] arr;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(arr, n, m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void bfs(int[][] arr, int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					q.add(new Dot(i, j));
				}
			}
		}
		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
				if (arr[nextX][nextY] != 0) {
					continue;
				}
				arr[nextX][nextY] = arr[d.x][d.y] + 1;
				q.add(new Dot(nextX, nextY));
			}
		}

		int max = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (arr[i][j] == 0) {
					// 토마토가 모두 익지 못한 상황이라면 -1 을 출력한다.
					System.out.println(-1);
					return;
				}
				max = Math.max(max, arr[i][j]);
			}
		}
		// 그렇지 않다면 최대값을 출력한다.
		System.out.println(max - 1);
	}
}

class Dot {
	int x;
	int y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
