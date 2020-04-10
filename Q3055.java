package study;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3055 {
	static int r, c;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static boolean visited[][];
	static int arr[][];
	static int x, y;
	static Queue<doch> q = new LinkedList<>();
	static Queue<Point> go = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			String tmp[] = s.split("");
			for (int j = 0; j < tmp.length; j++) {
				if (tmp[j].equals("S")) {
					go.add(new Point(i, j));
				} else if (tmp[j].equals("*")) {
					q.add(new doch(i, j, 1));
				} else if (tmp[j].equals("D")) {
					x = i;
					y = j;
				} else if (tmp[j].equals("X")) {
					visited[i][j] = true;
				}
			}
		}
		Point p = go.poll();
		BFS(p.x, p.y);
	}

	public static void BFS(int a, int b) {
		q.add(new doch(a, b, 0));
		visited[a][b] = true;
		boolean check = true;
		while (!q.isEmpty()) {
			doch p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c)
					continue;
				if (visited[nx][ny])
					continue;
				if (p.d == 0)
					arr[nx][ny] = arr[p.x][p.y] + 1;
				if (nx == x && ny == y && p.d == 0) {
					System.out.println(arr[nx][ny]);
					check = false;
					break;
				}
				if (nx == x && ny == y && p.d == 1) {
					continue;
				}
				visited[nx][ny] = true;
				q.add(new doch(nx, ny, p.d));
			}
			if (!check)
				break;
		}
		if (check)
			System.out.println("KAKTUS");
	}

}

class doch {
	int x, y, d;

	public doch(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}
