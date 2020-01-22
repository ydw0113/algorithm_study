package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Q14499 {
	private static int[][] map;
	private static int N;
	private static int M;
	private static int row;
	private static int col;
	private static int k;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 행은 남쪽 북쪽으로 움직일 때 관련있음
		int[] drow = new int[] { 0, 0, -1, +1 };
		int[] dcol = new int[] { 1, -1, 0, 0 };
		int[] dice = new int[7];

		int nrow, ncol;
		st = new StringTokenizer(br.readLine());
		while (k > 0) {
			int dir = Integer.parseInt(st.nextToken());
			nrow = row + drow[dir - 1];
			ncol = col + dcol[dir - 1];

			if (nrow >= 0 && nrow < N && ncol >= 0 && ncol < M) {
				int top = dice[1];
				if (dir == 1) { // 동쪽 탑이 오른쪽으로 감
					dice[1] = dice[4]; // 탑 = 왼쪽
					dice[4] = dice[6];
					dice[6] = dice[3];
					dice[3] = top;
				} else if (dir == 2) {
					dice[1] = dice[3];
					dice[3] = dice[6];
					dice[6] = dice[4];
					dice[4] = top;
				} else if (dir == 3) {// 북쪽 탑이 위쪽으로감
					dice[1] = dice[5];
					dice[5] = dice[6];
					dice[6] = dice[2];
					dice[2] = top;

				} else { // 입력값이 1~4까지만 들어온다는 가정하에
					dice[1] = dice[2];
					dice[2] = dice[6];
					dice[6] = dice[5];
					dice[5] = top;
				}
				row = nrow;
				col = ncol;
				if (map[row][col] == 0) {
					map[row][col] = dice[6];
				} else {
					dice[6] = map[row][col];
					map[row][col] = 0;
				}
				System.out.println(dice[1]);
			}
			k--;
		}
	}
}