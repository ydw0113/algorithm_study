package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7569 {
	static int[] dx = { -1, 0, 1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int h = sc.nextInt();

		Queue<Tomato> q = new LinkedList<Tomato>();

		int[][][] arr = new int[h][n][m];
		int[][][] dist = new int[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int z = 0; z < m; z++) {
					arr[i][j][z] = sc.nextInt();
					if (arr[i][j][z] == 1)
						q.add(new Tomato(i, j, z));
				}
			}
		}

		while (!q.isEmpty()) {
			Tomato t = q.poll();
			int x = t.x;
			int y = t.y;
			int z = t.z;
			for (int i = 0; i < dy.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];

				if (0 <= nx && nx < h && 0 <= ny && ny < n && 0 <= nz && nz < m) {
					if (arr[nx][ny][nz] == 0 && dist[nx][ny][nz] == 0) {
						q.add(new Tomato(nx, ny, nz));
						dist[nx][ny][nz] = dist[x][y][z] + 1;
					}
				}
			}
		}

		int answer = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int z = 0; z < m; z++) {
					if (answer < dist[i][j][z])
						answer = dist[i][j][z];
				}
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int z = 0; z < m; z++) {
					if (arr[i][j][z] == 0 && dist[i][j][z] == 0) {
						answer = -1;
					}
				}
			}
		}

		System.out.println(answer);

		sc.close();
	}
}

class Tomato {
	int x;
	int y;
	int z;

	Tomato(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}