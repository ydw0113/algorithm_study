package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17144 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n, m, t, count = 0, sum = 0, tmp = 0;
	static int[][] arr, copy;
	static boolean visited[][], flag;
	static Queue<DOT> q = new LinkedList<DOT>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		copy = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > 0)
					visited[i][j] = true;
				if (arr[i][j] == -1)
					tmp = i;
			}
		}
		bfs();
		System.out.println(sum);
	}

	public static void bfs() {
		while (t > 0) {
			copyMap();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] > 0) {
						q.add(new DOT(i, j));
						visited[i][j] = true;
					}
				}
			}

			while (!q.isEmpty()) {
				DOT d = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = d.x + dx[i];
					int ny = d.y + dy[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;
					if (arr[nx][ny] == -1)
						continue;
					arr[nx][ny] += (copy[d.x][d.y] / 5);
					count++;
				}
				arr[d.x][d.y] -= (copy[d.x][d.y] / 5) * count;
				count = 0;
			}
			 move();
			t--;
		}
		SUM();
	}

	public static void copyMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = arr[i][j];
			}
		}
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void SUM() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == -1)
					continue;
				else {
					sum += arr[i][j];
				}
			}
		}
	}

	public static void move() {
		for (int i = tmp - 2; i > 0; i--) {
			arr[i][0] = arr[i - 1][0];
		}
		for (int i = tmp + 1; i < n - 1; i++) {
			arr[i][0] = arr[i + 1][0];
		}
		for (int i = 0; i < tmp; i++) {
			for (int j = 1; j < m; j++) {
				if (arr[i][j] == -1)
					continue;
				else {
					if (i == 0) {
						arr[i][j - 1] = arr[i][j];
						if (j == m - 1) {
							for (int z = 1; z < tmp; z++) {
								arr[z - 1][j] = arr[z][j];
							}
							arr[tmp - 1][j] = 0;
						}
					} else if (i == tmp-1) {
						if (arr[i][m - 1] > 0 && !flag)
							break;
						else {
							if (arr[i][m - j - 1] == -1)
								arr[i][m - j] = 0;
							else {
								arr[i][m - j] = arr[i][m - j - 1];
							}
							flag = true;
						}
					}
				}
			}
			flag = false;
		}
		for (int i = n - 1; i >= tmp; i--) {
			for (int j = 1; j < m; j++) {
				if (arr[i][j] == -1)
					continue;
				else {
					if (i == n - 1) {
						arr[i][j - 1] = arr[i][j];
						if (j == m - 1) {
							for (int z = n - 2; z >= tmp; z--) {
								arr[z + 1][j] = arr[z][j];
							}
							arr[tmp][j] = 0;
						}
					} else if (i == tmp) {
						if (arr[i][m - 1] > 0 && !flag)
							break;
						else {
							if (arr[i][m - j - 1] == -1)
								arr[i][m - j] = 0;
							else {
								arr[i][m - j] = arr[i][m - j - 1];
							}
							flag = true;
						}
					}
				}
			}
			flag = false;
		}
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
