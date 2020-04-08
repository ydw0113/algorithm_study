package study;

import java.util.LinkedList;

public class Solution_04 {
	static LinkedList<String> list = new LinkedList<>();
	static boolean visited[];
	static String tmp[];
	static String answer = "";
	static int max = 0;
	static int index;

	public static String solution(String number, int k) {
		tmp = number.split("");
		visited = new boolean[tmp.length];

		solve(0, 0, tmp.length, tmp.length - k);
		answer += Integer.toString(max);
		System.out.println(answer);
		return Integer.toString(max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("1924", 2);
	}

	public static void solve(int start, int depth, int n, int k) {
		if (depth == k) {
			String s = "";
			for (String i : list) {
				s += i;
			}
			int a = Integer.parseInt(s);
			if (max < a) {
				max = a;
			}
			 System.out.println(s);
			return;
		}
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(tmp[i]);
				solve(start + 1, depth + 1, n, k);
				if(depth==k-1 && i==(tmp.length-k))
					break;
				list.removeLast();
				visited[i] = false;
			}

		}
	}

}
