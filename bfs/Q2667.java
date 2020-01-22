package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2667 {
	static boolean visited[][];
	static int arr[][];
	static int n;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int count = 0;
	static int count2 = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			String[] word = a.split("");
			for (int j = 0; j < word.length; j++) {
				arr[i][j] = Integer.parseInt(word[j]);
				visited[i][j] = false;
			}
		}
		int total = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					count = 0;
					count2 = 0;
					total++;
//					DFS(i, j);

					pq.add(count);
					BFS(i, j);
					pq2.add(count2);
				}
			}
		}
		System.out.println(total);
//		while (!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		System.out.println("bfs ");
		while (!pq2.isEmpty()) {
			System.out.println(pq2.poll());
		}
	}

	static void DFS(int x, int y) {
		arr[x][y] = 0;
		count++;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
				continue;
			}

			if (arr[nextX][nextY] == 0 || visited[nextX][nextY]) {
				continue;
			}
			DFS(nextX, nextY);
		}
	}

	static void BFS(int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x, y));
		arr[x][y] = 0;
		count2++;
		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
					continue;
				}

				if (arr[nextX][nextY] == 0 || visited[nextX][nextY]) {
					continue;
				}
				q.add(new Dot(nextX, nextY));
				arr[nextX][nextY] = 0;
				visited[nextX][nextY] = true;
				count2++;
			}
		}
	}

}
