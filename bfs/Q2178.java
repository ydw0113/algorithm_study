package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {

	static boolean visited[][];
	static int arr[][];
	static int n, m;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			String[] word = a.split("");
			for (int j = 0; j < word.length; j++) {
				arr[i][j] = Integer.parseInt(word[j]);
				visited[i][j] = false;
			}
		}
		visited[0][0] = true;
		BFS(0, 0);
		System.out.println(arr[n-1][m-1]);

	}

	static void BFS(int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x, y));

		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}

				if (arr[nextX][nextY] == 0 || visited[nextX][nextY]) {
					continue;
				}
				q.add(new Dot(nextX, nextY));
				arr[nextX][nextY] = arr[d.x][d.y] + 1;
				visited[nextX][nextY] = true;

			}
		}

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
