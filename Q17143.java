package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17143 {
	static int R, C, M, arr[][], man = 1, clone[][], min, answer = 0;
	static boolean visited[][], flag = false;
	static Queue<shark> q = new LinkedList<shark>();
	static Queue<shark> q2 = new LinkedList<shark>();

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
			q.add(new shark(r, c, s, d, z));
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
				// System.out.println(i + " " + m);
				break;
			}
		}
	}

	public static void move() {
		while (man <= C) {
			// System.out.println(man + "초");
			get(man);
			check();
			int tmp = q.size();
			for (int a = 0; a < tmp; a++) {
				shark sk = q.poll();
				if (visited[sk.r][sk.c]) {
					visited[sk.r][sk.c] = false;
					continue;
				}
				for (int i = 0; i < sk.s; i++) {
					if (sk.d == 1) {
						if (sk.r == 1) {
							sk.d = 2;
							sk.r++;
						} else
							sk.r--;
					} else if (sk.d == 2) {
						if (sk.r == R) {
							sk.d = 1;
							sk.r--;
						} else
							sk.r++;
					} else if (sk.d == 3) {
						if (sk.c == C) {
							sk.d = 4;
							sk.c--;
						} else
							sk.c++;
					} else if (sk.d == 4) {
						if (sk.c == 1) {
							sk.d = 3;
							sk.c++;
						} else
							sk.c--;
					}
				}
				if (arr[sk.r][sk.c] > 0) {
					if (arr[sk.r][sk.c] < sk.z) {
						int tm=q2.size();
						for (int i = 0; i < tm; i++) {
							shark s = q2.poll();
							if (s.z <= arr[sk.r][sk.c] && s.r == sk.r && s.c == sk.c) {
								continue;
							} else
								q2.add(new shark(s.r, s.c, s.s, s.d, s.z));
						}
						arr[sk.r][sk.c] = sk.z;
						q2.add(new shark(sk.r, sk.c, sk.s, sk.d, sk.z));
					} else
						continue;
				} else if (arr[sk.r][sk.c] == 0) {
					arr[sk.r][sk.c] = sk.z;
					q2.add(new shark(sk.r, sk.c, sk.s, sk.d, sk.z));
				}
			}
			int t = q2.size();
			for (int i = 0; i < t; i++) {
				shark s = q2.poll();
				// System.out.println(s.r + " " + s.c + " " + s.s + " " + s.d + " " + s.z);
				q.add(new shark(s.r, s.c, s.s, s.d, s.z));
			}

			man++;
			// System.out.println("크기" + answer);
		}
	}

	public static void check() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				arr[i][j] = 0;
			}
		}
	}
}

class shark {
	int r, c, s, d, z;

	public shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}
