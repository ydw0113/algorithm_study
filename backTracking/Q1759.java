package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1759 {
	static int visited[];
	static String[] result;
	static String arr[];
	static int l, c;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int count = 0;
	static int count2 = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new String[c];
		result = new String[l];
		visited = new int[c];
		for (int i = 0; i < c; i++)
			arr[i] = st.nextToken();

		Arrays.sort(arr);
		// for (int i = 0; i < c; i++)
		// System.out.print(arr[i] + " ");
		dfs(arr, 0, 0, l);

	}

	public static void dfs(String[] arr, int start, int depth, int l) {
		if (depth == l) {
			for (int i = 0; i < result.length; i++) {
				if (result[i].equals("a") || result[i].equals("e") || result[i].equals("i") || result[i].equals("o")
						|| result[i].equals("u"))
					count++;
				else
					count2++;
			}
			if (count > 0 && count2 > 1)
				print();

			count = 0;
			count2 = 0;
		} else if (depth < l) {
			for (int i = start; i < arr.length; i++) {
				visited[i] = 1;
				result[depth] = arr[i];
				dfs(arr, i + 1, depth + 1, l);
				visited[i] = 0;
			}
		}
	}

	public static void print() {
		for (int i = 0; i < l; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
	}
}
