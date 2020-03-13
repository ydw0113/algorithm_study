package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D2468 {
	static int n, arr[][], clone[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static boolean visited[][];
	static int count = 0;
	static int answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		clone = new int[n][n];
		visited = new boolean[n][n];
		int size = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				size = Math.max(size, arr[i][j]);
			}
		}
		int h = 0;
		while (h <= size) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					{
						bfs(i, j, h);
						if (count > 0) {
							answer++;
						}
						count = 0;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					visited[i][j] = false;
			}
			max = Math.max(answer, max);
			answer = 0;
			h++;
		}
		System.out.println(max);
	}

	public static void bfs(int x, int y, int h) {
		Queue<ddot> q = new LinkedList<ddot>();
		q.add(new ddot(x, y));
		if (arr[x][y] > h && !visited[x][y]) {
			visited[x][y] = true;
			count++;
		}
		while (!q.isEmpty()) {
			ddot d = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
					continue;
				}
				if (arr[nextX][nextY] <= h || visited[nextX][nextY])
					continue;
				if (!visited[d.x][d.y])
					continue;
				visited[nextX][nextY] = true;
				q.add(new ddot(nextX, nextY));
				count++;
			}
		}
	}

}

class ddot {
	int x, y;

	public ddot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
