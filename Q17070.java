package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17070 {
	static int n, count = 0;
	static int[][] arr;
	static boolean visited[];
	static int dx[] = { 0, 1, 1 };
	static int dy[] = { 1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 0, 1);
		System.out.println(count);
	}

	public static void dfs(int x, int y, int d) {
//		System.out.println(x+"  "+y+" "+d);
		if (y == n - 1 && x == n - 1) {
//			System.out.println("도착");
			count++;
			return;
		}
		int type[] = move(d);
		for (int i = 0; i < type.length; i++) {
			int nx = x + dx[type[i]];
			int ny = y + dy[type[i]];
			if (nx < 0 || ny < 0 || nx > n-1 || ny > n-1 || arr[ny][nx] != 0)
				continue;
			if (type[i] == 2 && (arr[y][x+1] != 0 || arr[y+1][x] != 0))
				continue;
			dfs(nx, ny, type[i]);
		}
	}

	public static int[] move(int d) {
		// 세로
		if (d == 0) {
			int[] ret = { 0, 2 };
			return ret;
		}
		// 가로
		else if (d == 1) {
			int[] ret = { 1, 2 };
			return ret;
		}
		// 대각선
		else if (d == 2) {
			int[] ret = { 0, 1, 2 };
			return ret;
		}
		return null;
	}

}
