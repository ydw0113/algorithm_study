package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11403 {
	static int n;
	static int[][] arr, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		result = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		// 한 줄씩 갈 수 있는곳을 모두 살펴보자.
		for (int i = 0; i < n; i++)
			solve(i, i);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void solve(int start, int next) {
		// start(시작 점)을 따라서 갈 수 있는 곳을 다 돌아다녀본다.
		for (int i = 0; i < n; i++) {
			// 원래 배열인 arr에서 1을 가르켜야 갈 수 있으며 갈 수 있다는 것은(맨 처음 next는 start)
			// start(시작 점)에서 갈 수 있으므로 1로 표시
			// result[start][i] 가 0이 아니라면 i는 이미 방문한 곳이므로 패스.
			if (arr[next][i] == 1 && result[start][i] == 0) {
				result[start][i] = 1;
				System.out.println(start+"    "+ i+"  "+next);
				solve(start, i);
			}
		}
	}
}
