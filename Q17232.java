package study;

import java.util.Scanner;

public class Q17232 {
	static int n, m, t, k, a, b;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static String s[];
	static int sum[][];
	static boolean visited[][];
	static boolean clone[][];
	static int sumClone[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		s = new String[n];
		k = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		visited = new boolean[n][m];
		clone = new boolean[n][m];
		sumClone = new int[n][m];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
			for (int j = 0; j < s[i].length(); j++) {
				if (s[i].charAt(j) == '*') {
					visited[i][j] = true;
					clone[i][j] = true;
				}
			}
		}


		while (t > 0) {
			copy();
			sum = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visited[i][j])
						sum[i][j]++;
					if (i - 1 >= 0) {
						if (j - 1 >= 0)
							sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
						else
							sum[i][j] += sum[i - 1][j];
					} else if (j - 1 >= 0) {
						sum[i][j] += sum[i][j - 1];
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(sum[i][j]);
				}
				System.out.println();
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (clone[i][j]) {
						if (check(i, j)) {
							visited[i][j] = false;
						}
					} else {
						if (check2(i, j)) {
							visited[i][j] = true;
						}
					}
				}
			}
			
			t--;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j])
					System.out.print("*");
				else
					System.out.print(".");
			}
			System.out.println();
		}
		sc.close();
	}

	public static void copy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				clone[i][j] = false;
				if (visited[i][j])
					clone[i][j] = true;
			}
		}
	}

	public static boolean check(int y, int x) {
		boolean flag = true;
		int count=0;
		if (y - k - 1 >= 0) {
			if (x - k - 1 >= 0)
				count = sum[y][x] - sum[y - k - 1][x] - sum[y][x - k - 1] + sum[y - k - 1][x - k - 1];
			else
				count = sum[y][x] - sum[y - k - 1][x];
		} else if (x - k - 1 >= 0) {
			count = sum[y][x] - sum[y][x - k - 1];
		}
		if (a <= count && b >= count)
			flag = false;
		System.out.println(y+" "+x+" "+count);
		return flag;
	}

	public static boolean check2(int y, int x) {
		boolean flag = false;
		int count=0;
		if (y - k - 1 >= 0) {
			if (x - k - 1 >= 0)
				count = sum[y][x] - sum[y - k - 1][x] - sum[y][x - k - 1] + sum[y - k - 1][x - k - 1];
			else
				count = sum[y][x] - sum[y - k - 1][x];
		} else if (x - k - 1 >= 0) {
			count = sum[y][x] - sum[y][x - k - 1];
		}
		if (a < count && b >= count)
			flag = true;
//		System.out.println(y+" "+x+" "+count);
		return flag;
	}

}
