package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17135 {
	static int n, m, d, count = 0;
	static int[][] arr;
	static boolean visited[], flag;
	static int dx[] = { 0, 1, 1 };
	static int dy[] = { 1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (!flag) {
			for (int i = n - 1; i > 0; i--) {
				for (int j = 0; j < m; j++) {
					if (i == n - 1) {
						System.out.println(Math.abs(i - (n-1)) + Math.abs(j - m));
						if (d >= (Math.abs(i - (n-1)) + Math.abs(j - m))) {
							count++;
						}

					}

					arr[i][j] = arr[i - 1][j];
					if (i == 1) {
						arr[i - 1][j] = 0;
					}
					if (arr[i][j] == 1) {
						flag = true;
					}
				}
			}
			if (flag)
				flag = false;
			else
				flag = true;
		}
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < m; j++) {
		// System.out.print(arr[i][j]);
		// }
		// System.out.println();
		// }
		System.out.println(count);
	}

	public static void dfs(int x, int y, int d) {

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {
				int nx = x + j;
				int ny = y + j;

			}
		}
	}

}
