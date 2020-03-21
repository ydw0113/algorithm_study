package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1520 {
	static int n, m, map[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int dp[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[m][n];
		dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0, 0));
		sc.close();
	}

	public static int dfs(int y, int x) {
		if (y == m - 1 && x == n - 1) {
			return 1;
		}

		if (dp[y][x] == -1) {
			dp[y][x] = 0;
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (map[y][x] > map[ny][nx]) {
						dp[y][x] += dfs(ny, nx);
					}
				}
			}
		}
		return dp[y][x];
	}

}