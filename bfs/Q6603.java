package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6603 {
	static int n;
	static int[] arr;
	static int[] result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			arr = new int[n];
			result = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			DFS(0, 0);
			System.out.println();
		}
	}

	static void DFS(int start, int depth) {
		if (depth == 6) {
			print();
		}
		for (int i = start; i < n; i++) {
			result[i] = 1;
			DFS(i + 1, depth + 1);
			result[i] = 0;
		}
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			if (result[i] == 1)
				System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
