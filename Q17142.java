package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17142 {
	static int n, m, d, count = 0, min = 10000000, count2 = 0;
	static int[][] arr, clone, clone2;
	static boolean visited[][], flag, check;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static Queue<DOT> virusList;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		clone = new int[n][n];
		clone2 = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				clone2[i][j] = arr[i][j];
				if (arr[i][j] == 1) {
					arr[i][j] = -1;
					count2++;
				}
				if (arr[i][j] == 2)
					count++;
			}
		}
		if (count + count2 == n * n)
			System.out.println("0");
		else {
			comb(0, 0);
			if (min == 10000000)
				min = -1;
			System.out.println(min);
		}
	}

	public static void BFS() {
		while (!virusList.isEmpty()) {
			DOT dot = virusList.poll();
			visited[dot.x][dot.y] = true;
			for (int i = 0; i < 4; i++) {
				int nextX = dot.x + dx[i];
				int nextY = dot.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
					continue;
				}
				if (clone[nextX][nextY] == -1 || visited[nextX][nextY]) {
					continue;
				}
				if (clone[nextX][nextY] == -9) {
					clone[nextX][nextY] = clone[dot.x][dot.y] + 1;
					virusList.add(new DOT(nextX, nextY));
					visited[nextX][nextY] = true;
					continue;
				} else {
					clone[nextX][nextY] = clone[dot.x][dot.y] + 1;
					virusList.add(new DOT(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}

	public static void comb(int start, int depth) {
		if (depth == count - m) {
			copyMap();
			virusList = new LinkedList<DOT>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i][j] = false;
					if (arr[i][j] == 2) {
						virusList.add(new DOT(i, j));
					}
				}
			}
			BFS();
//			print();
			if (getArea() > 0) {
				min = Math.min(min, getArea());
			}
			return;
		}
		for (int i = start; i < n * n; i++) {
			int x = i / n;
			int y = i % n;

			if (arr[x][y] == 2) {
				arr[x][y] = -9;
				comb(i + 1, depth + 1);
				arr[x][y] = 2;
			}
		}
	}

	static int getArea() {
		int max = 0;
		flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (clone2[i][j] == 2 && clone[i][j] != 0) {
					clone[i][j] -= 1;
				}
				max = Math.max(clone[i][j], max);
				if (clone[i][j] == 0 && clone2[i][j] != 2)
					flag = true;
			}
		}
		if (flag)
			max = -1;
		return max;
	}

	static void copyMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				clone[i][j] = arr[i][j];
				if (clone[i][j] == 2)
					clone[i][j] = 0;
			}
		}
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(clone[i][j] + " ");
			}
			System.out.println();
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