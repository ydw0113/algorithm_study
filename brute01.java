package study;

import java.util.LinkedList;

public class brute01 {
	static LinkedList<Integer> list = new LinkedList<>();
	static LinkedList<Integer> li = new LinkedList<>();

	public static int brute01(String numbers) {
		int answer = 0;
		int n = numbers.length();
		int arr[] = new int[n];
		String s[] = numbers.split("");
		boolean visited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		for (int i = 1; i <= n; i++)
			solve(n, arr, visited, 0, i);
		answer = li.size();
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "011";
		brute01(s);
	}

	public static void solve(int n, int arr[], boolean visited[], int depth, int r) {
		if (depth == r) {
			String s = "";
			for (int i : list) {
				s += Integer.toString(i);
			}
			int tmp = Integer.parseInt(s);
			if (li.contains(tmp))
				return;
			int count = 0;
			for (int i = 2; i < tmp; i++) {
				if (tmp % i == 0) {
					count++;
					break;
				}
			}
			if (count == 0 && tmp > 1) {
				if (!li.contains(tmp)) {
					li.add(tmp);
				}
			}
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					list.add(arr[i]);
					solve(n, arr, visited, depth + 1, r);
					visited[i] = false;
					list.removeLast();
				}
			}
		}
	}
}
