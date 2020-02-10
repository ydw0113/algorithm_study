package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q17406 {
	static int n, m, k, s[], r[], c[], S, C[];
	static LinkedList<Integer> com = new LinkedList<Integer>();
	static int arr[][], copy[][];
	static boolean visited[];
	static int min = 100000000;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];
		copy = new int[n + 1][m + 1];
		r = new int[k];
		c = new int[k];
		s = new int[k];
		C = new int[k];
		visited = new boolean[k];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < m + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
			C[i] = i;
		}
		comb(0, 0);
		System.out.println(min);
	}

	static void copyMap() {
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				copy[i][j] = arr[i][j];
			}
		}
	}

	static void spin(int a, int b, int a2, int b2) {
		for (int z = 1; z <= S; z++) {
			int T = a + z - 1;
			int B = a2 - z + 1;
			int R = b2 - z + 1;
			int L = b + z - 1;

			int tmp = copy[z + a - 1][R];
			for (int i = R; i > L; i--)
				copy[T][i] = copy[T][i - 1];
			for (int i = T; i < B; i++)
				copy[i][L] = copy[i + 1][L];
			for (int i = L; i < R; i++)
				copy[B][i] = copy[B][i + 1];
			for (int i = B; i > T; i--)
				copy[i][R] = copy[i - 1][R];
			copy[T + 1][R] = tmp;

		}
	}

	private static void print() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(copy[i][j]);
			}
			System.out.println();
		}
	}

	private static void MIN() {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sum += copy[i][j];
			}
//			System.out.println(sum);
			min = Math.min(min, sum);
			sum = 0;
		}
	}

	static void comb(int start, int depth) {
		if (depth == k) {
			copyMap();
			for (int i : com) {
//				System.out.print(i+"  ");
				int a = r[i] - s[i];
				int b = c[i] - s[i];
				int a2 = r[i] + s[i];
				int b2 = c[i] + s[i];
				S = Math.min(a2, b2) / 2;
				spin(a, b, a2, b2);
			}
//			System.out.println();
//			print();
			MIN();
			return;

		} else {
			for (int i = 0; i < k; i++) {
				if (!visited[i]) {
					com.add(i);
					visited[i] = true;
					comb(i + 1, depth + 1);
					visited[i] = false;
					com.removeLast();
				}
			}
		}

	}
}
