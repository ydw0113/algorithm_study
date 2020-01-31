package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q16637 {
	static int n, sum = 0, max = 0;
	static String arr[], answer[], copy[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = sc.nextInt();
		String tmp = br.readLine();
		arr = tmp.split("");
		answer = new String[n];
		copy = new String[n / 2];
		visited = new boolean[n];
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 != 0) {
				copy[cnt++] = arr[i];
				if (arr[i].equals("+")) {
//					sum+=arr[i-1]+arr[i+1];
				} else if (arr[i].equals("*")) {

				} else if (arr[i].equals("-")) {

				} else if (arr[i].equals("/")) {

				}

			}
		}

//		for (int i = 1; i <= copy.length; i++)
			solve(0, 0, n);

	}

	public static void solve(int start, int depth, int r) {
		if (depth == r) {
			max = Math.max(max, sum);
			sum = 0;
			print(r);
			return;
		} else {
			for (int i = start; i < arr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					answer[depth] = arr[i];
//					System.out.print(arr[i]);
					solve(start + 1, depth + 1, r);
					visited[i] = false;
				}
			}

		}

	}

	static void SUM() {
		for (int i = 0; i < n; i++) {

		}
	}

	static void print(int r) {
		for (int i = 0; i < r; i++)
			System.out.print(answer[i] + " ");
		System.out.println();
	}

}
