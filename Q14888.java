package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q14888 {
	static int size = 0;
	static int arr[];
	static int cal[] = { 0, 0, 0, 0 };
	static long sum = 0, max = -1000000000, min = 1000000000;
	static boolean visited[];
	static ArrayList<Integer> outputList = new ArrayList<Integer>();
	static ArrayList<Integer> inputList = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		visited = new boolean[n - 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > 0) {
				for (int j = 0; j < num; j++) {
					inputList.add(i);
				}
			}
		}

		solve(n - 1, 0);
		System.out.println(max);
		System.out.println(min);
	}

	public static void solve(int n, int depth) {
		if (depth == n) {
			int a = 1;
			sum = arr[0];
			for (int i : outputList) {
				if (i == 0) {
					sum += arr[a];
				} else if (i == 1) {
					sum -= arr[a];
				} else if (i == 2) {
					sum *= arr[a];
				} else if (i == 3) {
					sum /= arr[a];
				}
				a++;
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				outputList.add(inputList.get(i));
				solve(n, depth + 1);
				outputList.remove(outputList.size() - 1);
				visited[i] = false;
			}
		}
	}
}
