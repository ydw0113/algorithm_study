package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2644 {
	static int n, a, b, k;
	static int arr[][], count[];
	static boolean visited[];
	static Queue<Integer> q = new LinkedList<>();
	static boolean flag = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		count = new int[n + 1];
		a = sc.nextInt();
		b = sc.nextInt();
		k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = arr[y][x] = 1;
		}
		bfs(a);
		for(int i=1;i<=n; i++)
			System.out.print(count[i]+" ");
		if (!flag)
			count[b] = -1;
//		System.out.println(count[b]);
		sc.close();
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
					System.out.println(i+"  "+d);
					count[i] = count[d] + 1;
					if (i == b) {
						flag = true;
						return;
					}
				}
			}
		}
	}
}
