package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q17779 {
	static int n, x, y, d1, d2, sumMin = 1000000;
	static int arr[][], clone[][];
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		clone = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(4);
		System.out.println(sumMin);
	}

	public static void solve(int x, int y, int d1, int d2) {

		for (int i = 0; i < n; i++) {
			if (x + i <= x + d1 && y - i >= y - d1) {
				clone[x + i][y - i] = 5;
			}
			if (x + i <= x + d2 && y + i <= y + d2) {
				clone[x + i][y + i] = 5;
			}
			if (x + d1 + i <= x + d1 + d2 && y - d1 + i <= y - d1 + d2) {
				clone[x + d1 + i][y - d1 + i] = 5;
			}
			if (x + d2 + i <= x + d1 + d2 && y + d2 - i >= y + d2 - d1) {
				clone[x + d2 + i][y + d2 - i] = 5;
			}
		}
		for (int i = 1; i <= n; i++) {
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if (clone[i][j] == 5)
					count++;
			}
			if (count <= 1)
				continue;
			else if (count == 2) {
				for (int j = 1; j <= n; j++) {
					if (clone[i][j] == 5) {
						count--;
						continue;
					}
					if (count == 1)
						clone[i][j] = 5;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (clone[i][j] == 5)
					continue;
				if (1 <= i && i < x + d1 && 1 <= j && j <= y) {
					clone[i][j] = 1;
				} else if (1 <= i && i <= x + d2 && y < j && j <= n) {
					clone[i][j] = 2;
				} else if (x + d1 <= i && i <= n && 1 <= j && j < y - d1 + d2) {
					clone[i][j] = 3;
				} else if (x + d2 < i && i <= n && y - d1 + d2 <= j && j <= n) {
					clone[i][j] = 4;
				}
			}
		}
	}

	public static void comb(int r) {
		if (list.size() == r) {
			x = list.get(0);
			y = list.get(1);
			d1 = list.get(2);
			d2 = list.get(3);
			if (d1 >= 1 && d2 >= 1 && 1 <= x && x < x + d1 + d2 && x + d1 + d2 <= n && 1 <= y - d1 && y - d1 < y
					&& y < y + d2 && y + d2 <= n) {
				solve(x, y, d1, d2);
				sumMin = Math.min(sumMin, MIN());
//				print();
				copy();
			}
			return;
		} else {
			for (int i = 1; i <= n; i++) {
				list.add(i);
				comb(r);
				list.removeLast();
			}
		}
	}

	public static void copy() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				clone[i][j] = 0;
			}
		}
	}

	public static void print() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				System.out.print(clone[i][j] + " ");
			System.out.println();
		}
	}

	public static int MIN() {
		int sum[] = new int[5];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (clone[i][j] == 1) {
					sum[0] += arr[i][j];
				} else if (clone[i][j] == 2) {
					sum[1] += arr[i][j];
				} else if (clone[i][j] == 3) {
					sum[2] += arr[i][j];
				} else if (clone[i][j] == 4) {
					sum[3] += arr[i][j];
				} else if (clone[i][j] == 5) {
					sum[4] += arr[i][j];
				}
			}
		}
		int max = sum[0], min = sum[0];
		for (int i = 0; i < 5; i++) {
			max = Math.max(max, sum[i]);
			min = Math.min(min, sum[i]);
		}
		return max - min;

	}

}
