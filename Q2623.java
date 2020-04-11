package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2623 {
	static int N;
	static int M;
	static int[][] link;
	static LinkedList<Integer>[] list;
	static int[] in;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		in = new int[N + 1];
		link = new int[N + 1][N + 1];
		list = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			int size = sc.nextInt();
			int from = sc.nextInt();
			for (int k = 1; k < size; k++) {
				int to = sc.nextInt();
				if (link[from][to] == 0) {
					link[from][to] = 1;
					list[from].add(to);
					in[to]++;
				}
				from = to;
			}
		}
		sc.close();
		StringBuffer buffer = new StringBuffer();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (in[i] == 0) {
				queue.add(i);
				buffer.append(i).append("\n");
			}
		}
		if (queue.isEmpty()) {
			System.out.println(0);
			return;
		}
		while (!queue.isEmpty()) {
			int from = queue.poll();
			for (int to : list[from]) {
				if (link[from][to] == 1) {
					if (--in[to] == 0) {
						queue.add(to);
						link[from][to] = 0;
						buffer.append(to).append("\n");
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (in[i] != 0) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(buffer.toString());
	}
}
