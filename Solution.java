package study;
import java.util.LinkedList;

public class Solution {
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static String s="";
	static int max = 0;

	public static String solution(int[] numbers) {
		String answer = "";
		int n = numbers.length;
		int m = numbers.length;
		boolean visited[] = new boolean[n];
		solve(numbers, visited, n, m, 0);
		answer = Integer.toString(max);
		return answer;
	}

	public static void solve(int arr[], boolean visited[], int n, int m, int depth) {
		if (depth == m) {
			for (int i : list) {
				s += i;
			}
			
			s="";
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(arr[i]);
				solve(arr, visited, n, m, depth + 1);
				visited[i] = false;
				list.removeLast();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 3,30,34,5,99,9,9,9,9,9,9 };
		System.out.println(solution(a));

	}
}