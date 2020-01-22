package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987 {
	static boolean visited[][];
	static int r, c;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int count = 0;
	static boolean flag = true;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		String arr[][] = null;
		arr = new String[r][c];
		String a[] = new String[r * c];
		for (int i = 0; i < a.length; i++)
			a[i] = "a";
		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String a2 = br.readLine();
			String[] word = a2.split("");
			for (int j = 0; j < word.length; j++) {
				arr[i][j] = word[j];
				visited[i][j] = false;
			}
		}
		a[0] = arr[0][0];
		System.out.println(DFS(a, arr, 0, 0, 1));
	}

	static int DFS(String[] a, String arr[][], int x, int y, int depth) {
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) {
				continue;
			}
			for (int j = 0; j < a.length - 1; j++) {
				System.out.println(depth + " " + arr[nextX][nextY] + " " + a[j]);
				if (a[j].equals(arr[nextX][nextY]) || visited[nextX][nextY]) {
					flag = false;
					break;
				} else if (a[j + 1].equals("a")) {
					flag = true;
					break;
				}
			}
			if (flag) {
				a[depth] = arr[nextX][nextY];
				visited[nextX][nextY] = true;
				DFS(a, arr, nextX, nextY, depth + 1);
			} else
				continue;
		}
		return max = Math.max(max, depth);

	}
}
