package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q15685 {
	static int n, count = 0;
	static Queue<dra> q = new LinkedList<dra>();
	static Queue<Integer> map;
	static int arr[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[101][101];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			q.add(new dra(x, y, d, g));
		}
		solve();
		print();
		System.out.println(count);
	}

	public static void solve() {
		while (!q.isEmpty()) {
			dra dr = q.poll();
			map = new LinkedList<Integer>();
			int x = dr.x;
			int y = dr.y;
			int d = dr.d;
			int g = dr.g;
			int t = 0;
			int dir;
			int gen = 1;
			int clone[] = new int[10000];
			arr[y][x] = 1;
			map.add(d);
			while (g >= t) {
				int tmp = map.size();
				for (int i = 0; i < tmp; i++) {
					int b = map.poll();
					clone[i] = b;
					map.add(b);
				}

				for (int i = tmp; i > 0; i--) {
					dir = (clone[i - 1] + 1) % 4;
					map.add(dir);
				}
				gen = (int) Math.pow(2, t);
				t++;
			}

			for (int i = 0; i < gen; i++) {
				dir = map.poll();
				// 오른쪽
				if (dir == 0) {
					arr[y][x + 1] = 1;
					x++;
				}
				// 위
				else if (dir == 1) {
					arr[y - 1][x] = 1;
					y--;
				}
				// 왼쪽
				else if (dir == 2) {
					arr[y][x - 1] = 1;
					x--;
				}
				// 아래
				else if (dir == 3) {
					arr[y + 1][x] = 1;
					y++;
				}
			}
		}

	}

	public static void print() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i][j + 1] == 1 && arr[i + 1][j + 1] == 1)
					count++;
			}
		}
	}

}

class dra {
	int x, y, d, g;

	public dra(int x, int y, int d, int g) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.g = g;
	}
}