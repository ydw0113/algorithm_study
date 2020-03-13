package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q10026 {
	static int n;
	static String arr[][];
	static boolean visited[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int count = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new String[n][n];
		visited = new boolean[n][n];
		int answer = 0;
		for (int i = 0; i < n; i++) {
			String t = br.readLine();
			String a[] = t.split("");
			for (int j = 0; j < a.length; j++) {
				arr[i][j] = a[j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && arr[i][j].equals("R")) {
					// count++;
					bfs(i, j, "R");
					answer++;
				} else if (!visited[i][j] && arr[i][j].equals("G")) {
					bfs(i, j, "G");
					answer++;
				} else if (!visited[i][j] && arr[i][j].equals("B")) {
					bfs(i, j, "B");
					answer++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
				if (arr[i][j].equals("G"))
					arr[i][j] = "R";
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && arr[i][j].equals("R")) {
					bfs(i, j, "R");
					count++;
				} else if (!visited[i][j] && arr[i][j].equals("B")) {
					bfs(i, j, "B");
					count++;
				}
			}
		}
		System.out.println(answer+" "+count);

	}

	public static void bfs(int x, int y, String s) {
		Queue<dodo> q = new LinkedList<dodo>();
		q.add(new dodo(x, y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			dodo d = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (!visited[nx][ny] && arr[nx][ny].equals(s)) {
					visited[nx][ny] = true;
					q.add(new dodo(nx, ny));
				}
			}
		}
	}

}

class dodo {
	int x, y;

	public dodo(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
