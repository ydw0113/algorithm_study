package study;

import java.util.*;
import java.io.*;

public class Q1080 {
	static int n, m;
	static int a[][], b[][];

	public static boolean flip(int start_a, int start_b) { // 변환 연산메소드

		if (start_a + 3 > n || start_b + 3 > m)
			return false; // 전달받은 i와j가 범위를 벗어난다면 false 반환

		for (int i = start_a; i <= start_a + 2; i++) { // 3x3크기만큼 변환연산을 수행해 준 후 true를 반환
			for (int j = start_b; j <= start_b + 2; j++) {
				a[i][j] = 1 - (a[i][j]);
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new int[n][m];
		b = new int[n][m];

		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = row.charAt(j) - '0';

			}
		}
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				b[i][j] = row.charAt(j) - '0';

			}
		}

		int cnt = 0;
		// 원소 하나하나를 비교해서 다를 때 마다 flip메소드 호출, 범위를 벗어날 때 까지 같지 않다면
		// 같아질수 없는 배열들이므로 -1출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (a[i][j] != b[i][j]) {
					if (flip(i, j)) {
						cnt++;
					} else {
						System.out.println("-1");
						return;
					}
				}

			}
		}

		System.out.println(cnt);
		br.close();

	}

}