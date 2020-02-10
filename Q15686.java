package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q15686 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n, m, sum = 0, min = 10000000;
	static int[][] arr, copy;
	static boolean visited[][];
	static Queue<DOT> chicken;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		copy = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);
		System.out.println(min);
	}

	public static void comb(int start, int depth) {
		if (depth == m) {
			copyMap();
			chicken = new LinkedList<DOT>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i][j] = false;
					if (copy[i][j] == -9) {
						chicken.add(new DOT(i, j));
					}
				}
			}
			dis();
			SUM();
			min = Math.min(sum, min);
			sum = 0;
		} else {
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
	}

	public static void SUM() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (copy[i][j] == -9)
					continue;
				else {
					sum += copy[i][j];
				}
			}
		}
	}

	public static void copyMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = arr[i][j];
				if (copy[i][j] == 2)
					copy[i][j] = 0;
				if (copy[i][j] == 1)
					copy[i][j] = 200;
			}
		}
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void dis() {
		int d;
		while (!chicken.isEmpty()) {
			DOT dist = chicken.poll();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (copy[i][j] > 0) {
						d = Math.abs((i - dist.x)) + Math.abs((j - dist.y));
						copy[i][j] = Math.min(d, copy[i][j]);
					}
				}
			}
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
