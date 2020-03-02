package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17837 {
	static int n, k, nx, ny, nd, qsize;
	static int arr[][], clone[][];
	static boolean flag;
	static Queue<Integer>[][] q;
	static LinkedList<ch> list = new LinkedList<ch>();
	static LinkedList<Integer> tmp;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n + 2][n + 2];
		clone = new int[n + 2][n + 2];
		q = new LinkedList[n + 2][n + 2];

		for (int i = 0; i <= n + 1; i++) {
			for (int j = 0; j <= n + 1; j++) {
				arr[i][j] = 2;
				q[i][j] = new LinkedList<>();
			}
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		list.add(new ch(0, 0, 0));
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new ch(x, y, d));
			q[x][y].add(i);
		}
		solve();

	}

	public static void solve() {
		int ans = -1;
		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= k; j++) {
				nx = list.get(j).x;
				ny = list.get(j).y;
				nd = check_go(j);

				if (nd == 2)
					change_dir(j);
				else {
					if (nd == 1)
						change_dir(j);
					go(j);
					add();
				}
				if (q[nx][ny].size() >= 4) {
					ans = i;
					break;
				}
			}
			if (ans != -1)
				break;
		}
		System.out.println(ans);
	}

	public static int check_go(int now) {
		int dir = list.get(now).d;
		int cnt = 0;
		if (arr[nx + dx[dir]][ny + dy[dir]] == 2) {
			cnt++;
			if (arr[nx - dx[dir]][ny - dy[dir]] == 2)
				cnt++;
		}
		return cnt;
	}

	public static void go(int cur) {
		tmp = new LinkedList<>();
		boolean find = false;
		qsize = q[nx][ny].size();
		for (int i = 0; i < qsize; i++) {
			int a = q[nx][ny].poll();
			if (a == cur)
				find = true;
			if (find)
				tmp.add(a);
			else
				q[nx][ny].add(a);
		}
		nx = list.get(cur).x = list.get(cur).x + dx[list.get(cur).d];
		ny = list.get(cur).y = list.get(cur).y + dy[list.get(cur).d];
	}

	public static void change_dir(int now) {
		int tdir = list.get(now).d;
		if (tdir == 1)
			list.get(now).d = 2;
		else if (tdir == 2)
			list.get(now).d = 1;
		else if (tdir == 3)
			list.get(now).d = 4;
		else
			list.get(now).d = 3;
	}

	private static void add() {
		if (arr[nx][ny] == 0) {
			for (int i = 0; i < tmp.size(); i++) {
				q[nx][ny].add(tmp.get(i));
				list.get(tmp.get(i)).x = nx;
				list.get(tmp.get(i)).y = ny;
			}
		} else {
			for (int i = tmp.size() - 1; i >= 0; i--) {
				q[nx][ny].add(tmp.get(i));
				list.get(tmp.get(i)).x = nx;
				list.get(tmp.get(i)).y = ny;
			}
		}
	}
}

class ch {
	int x, y, d;

	public ch(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}
