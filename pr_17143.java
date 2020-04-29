package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pr_17143 {
	static int R, C, M, arr[][], man = 1, clone[][], min, answer = 0;
	static boolean visited[][], flag = false;
	static Queue<shark2> q = new LinkedList<shark2>();
	static Queue<shark2> q2 = new LinkedList<shark2>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[R + 1][C + 1];
		visited = new boolean[R + 1][C + 1];
		clone = new int[R + 1][C + 1];
		min = R + 1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			q.add(new shark2(r, c, s, d, z));
			arr[r][c] = z;
		}
		move();
		System.out.println(answer);
	}

	public static void get(int m) {
		for (int i = 1; i <= R; i++) {
			if (arr[i][m] > 0) {
				visited[i][m] = true;
				answer += arr[i][m];
				break;
			}
		}
	}

	public static void clear() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				arr[i][j] = 0;
			}
		}
	}

	public static void move() {
		while (man <= C) {
			get(man);
			clear();
			int tmp = q.size();
			for (int i = 0; i < tmp; i++) {
				shark2 sk = q.poll();
				if (visited[sk.r][sk.c]) {
					visited[sk.r][sk.c] = false;
					continue;
				}
				// 상어 이동
				for (int j = 0; j < sk.s; j++) {
					if (sk.d == 1) {
						if (sk.r == 1) {
							sk.r++;
							sk.d = 2;
						} else
							sk.r--;
					} else if (sk.d == 2) {
						if (sk.r == R) {
							sk.r--;
							sk.d = 1;
						} else
							sk.r++;
					} else if (sk.d == 3) {
						if (sk.c == C) {
							sk.c--;
							sk.d = 4;
						} else
							sk.c++;
					} else if (sk.d == 4) {
						if (sk.c == 1) {
							sk.c++;
							sk.d = 3;
						} else
							sk.c--;
					}
				}

				// 상어 이동 후 잡아먹고 큐 재정렬
				if (arr[sk.r][sk.c] < sk.z) {
					arr[sk.r][sk.c] = sk.z;
				}
				q2.add(new shark2(sk.r, sk.c, sk.s, sk.d, sk.z));
			}
			while (!q2.isEmpty()) {
				shark2 sk = q2.poll();
				if (arr[sk.r][sk.c] == sk.z)
					q.add(new shark2(sk.r, sk.c, sk.s, sk.d, sk.z));
			}
			man++;
		}
	}

}

class shark2 {
	int r, c, s, d, z;

	public shark2(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}