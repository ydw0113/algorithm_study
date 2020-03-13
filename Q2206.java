package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {
	static int n, m;
	static int arr[][], clone[][];
	static boolean visited[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int count = 0;
	static int min = 10000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		clone = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String t = br.readLine();
			String a[] = t.split("");
			for (int j = 0; j < a.length; j++) {
				if (a[j].equals("1")) {
					arr[i][j] = -9;
				} else
					arr[i][j] = 0;
			}
		}

		comb(0);
		if (min == 10000000)
			System.out.println("-1");
		else {
			System.out.println(min);
		}

	}

	public static void bfs(int x, int y) {
		Queue<ddo> q = new LinkedList<ddo>();
		q.add(new ddo(x, y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			ddo d = q.poll();
			if (min < clone[d.x][d.y])
				break;
			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (clone[nx][ny] == -9 || visited[nx][ny])
					continue;
				visited[nx][ny] = true;
				clone[nx][ny] = clone[d.x][d.y] + 1;
				q.add(new ddo(nx, ny));
			}
		}
	}

	public static void comb(int depth) {
		if (depth == 1) {
			copyMap();
			bfs(0, 0);
			if (clone[n - 1][m - 1] != 0)
				min = Math.min(min, clone[n - 1][m - 1]);
			return;
		}
		for (int i = 0; i < n * m; i++) {
			int x = i / m;
			int y = i % m;
			if (arr[x][y] == -9) {
				arr[x][y] = 0;
				comb(depth + 1);
				arr[x][y] = -9;
			}
		}
	}

	public static void copyMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				clone[i][j] = arr[i][j];
				visited[i][j] = false;
			}
		}
		clone[0][0] = 1;

	}
}

class ddo {
	int x, y;

	public ddo(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
