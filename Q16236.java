package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16236 {
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int n, time = 0, sum = 0, tmp = 0, size = 2;
	static int[][] arr, copy;
	static boolean visited[][], flag2;
	static Queue<DOT> q = new LinkedList<DOT>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		copy = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					q.add(new DOT(i, j));
					visited[i][j]=true;
					arr[i][j]=0;
				}
			}
		}
		copyMap();
		bfs();
		if (size == 2)
			time = 0;
		System.out.println(time + "  크기" + tmp);

	}

	public static void bfs() {

		while (!q.isEmpty()) {
			DOT d = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (arr[nx][ny] > size || visited[nx][ny])
					continue;

				if (!check()) {
					flag2 = true;
					break;
				}
				copy[nx][ny] = copy[d.x][d.y] + 1;
				if (arr[nx][ny] > 0 && arr[nx][ny] < size) {
					time += copy[nx][ny];
					arr[nx][ny] = 0;
					copyMap();
					tmp++;
					visited[nx][ny] = true;
					q.clear();
					q.add(new DOT(nx, ny));
					System.out.println(nx+" "+ny+" size= "+size+" t "+time);
					print();
					System.out.println();
					if (tmp == size) {
						size++;
						copyMap();
						tmp = 0;
						break;
					}
					break;
				} else {
					visited[nx][ny] = true;
					q.add(new DOT(nx, ny));
				}
			}
			if (flag2)
				break;
			
		}
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void tr() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j]=false;
			}
		}
	}

	public static void copyMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
				copy[i][j] = arr[i][j];
				if (copy[i][j] == 9)
					copy[i][j] = 0;
			}
		}
	}

	public static boolean check() {
		int count = 0;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] <= 6 && arr[i][j] >= 1) {
					flag = true;
					if (arr[i][j] < size) {
						count++;
					}
				}
			}
		}
		if (count == 0)
			return false;
		else
			return flag;
	}

}

class DOT {
	int x;
	int y;

	public DOT(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
