package study;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11724 {
	static int n, m;
	static int arr[][];
	static boolean visited[];
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = arr[y][x] = 1;
		}
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				bfs(i);
				count++;
			}
		}
		System.out.println(count);
	}

	public static void bfs(int x) {
		q.add(x);
		visited[x] = true;
		while (!q.isEmpty()) {
			int d = q.poll();
			for (int i = 1; i <= n; i++) {
				if (arr[d][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

}
