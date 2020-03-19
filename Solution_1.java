package study;

import java.util.LinkedList;

public class Solution_1 {
	static long m = 0;
	static int arr[];
	static StringBuilder s = new StringBuilder();
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static LinkedList<Integer> an = new LinkedList<Integer>();
	static boolean visited[];

	public static int[] Solution_1(int n, long k) {

		arr = new int[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++)
			arr[i] = i + 1;
		
		solve(0, k, n);
		int[] answer = new int[an.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = an.poll();
			System.out.print(answer[i]);
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		long k = 5;
		Solution_1(3, 5);
	}

	public static void solve(int depth, long k, int n) {
		if (!an.isEmpty())
			return;
		if (depth == n) {
			m++;
			if (k == m) {
				for (int i : list) {
					an.add(i);
				}
				return;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(arr[i]);
				solve(depth + 1, k, n);
				if (!an.isEmpty())
					return;
				list.removeLast();
				visited[i] = false;
			}
		}
	}

}
