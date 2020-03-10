package study;

import java.util.*;

public class Q15684 {
	static int n, m, h, count = 0, max;
	static boolean arr[][], flag = false;

	public static boolean check() {
		for (int i = 1; i <= m; i++) {
			int start = i, end = i;
			for (int j = 1; j <= n; j++) {
				if (arr[j][end]) {
					end++;
				} else if (end == 1)
					continue;
				else if (!arr[j][end]) {
					if (arr[j][end - 1])
						end--;
				}
			}
			// System.out.println(start+" "+end);
			if (start != end)
				return false;
		}
		return true;
	}

	public static void solve(int start, int depth, int r) {
		if (flag)
			return;

		if (r == max) {
//			System.out.println(check());
			if (check()) {
				flag = true;
			}
			return;
		} else {
			for (int i = start; i < m * n; i++) {
				int x = i / m+1;
				int y = i % m+1;
				
				if (y - 1 < 0 || y >= m)
					continue;
//				System.out.println(x+" "+y);

				if (arr[x][y] || arr[x][y - 1] || arr[x][y + 1])
					continue;

				arr[x][y] = true;
				solve(i + 1, depth + 1, r + 1);
				arr[x][y] = false;

			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		h = sc.nextInt();
		n = sc.nextInt();
		arr = new boolean[n + 1][m + 1];

		for (int i = 0; i < h; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = true;
		}
		for (int i = 0; i <= 3; i++) {
			max = i;
			solve(0, 0, 0);
			if (flag)
				break;
		}
		System.out.println(flag ? max : -1);
		sc.close();
	}
}