package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14890 {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int n;
	static int L;
	static int[][] map;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		L = stoi(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = stoi(st.nextToken());
		}

		// 풀이 시작
		for (int i = 0; i < n; i++) {
			if (canGo(i, 0, 0))
				count++;

			if (canGo(0, i, 1))
				count++;
		}

		System.out.println(count);
	}

	// 한 줄이 경사로인지 확인 d = 0 이면 행검사, d = 1 이면 열검사
	static boolean canGo(int x, int y, int d) {
		int[] height = new int[n];
		boolean[] visited = new boolean[n]; // 경사로가 이미 놓여있는지 체크

		// 알아보기 쉽게 height 배열에 옮기기
		for (int i = 0; i < n; i++) {
			if (d == 0)
				height[i] = map[x][y + i];
			else
				height[i] = map[x + i][y];
		}

		for (int i = 0; i < n - 1; i++) {
			// 높이가 같으면 패스
			if (height[i] == height[i + 1])
				continue;

			if (Math.abs(height[i] - height[i + 1]) > 1)
				return false;

			// 내려가야되는 경우
			if (height[i] - 1 == height[i + 1]) {
				for (int j = i + 1; j <= i + L; j++) {
					// j가 범위를 벗어나거나 높이가 다르거나 이미 경사로가 있는 경우
					if (j >= n || height[i + 1] != height[j] || visited[j] == true)
						return false;
					visited[j] = true;
				}
			}
			// 올라가야되는 경우
			else if (height[i] + 1 == height[i + 1]) {
				for (int j = i; j > i - L; j--) {
					if (j < 0 || height[i] != height[j] || visited[j] == true)
						return false;
					visited[j] = true;
				}
			}
		}

		return true;
	}
}