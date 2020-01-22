package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17825 {
	static int n, count = 0;
	static int arr[], one[] = { 10, 13, 16, 19, 25, 26, 27, 28 }, two[] = { 20, 22, 24, 25, 30, 35, 40 },
			three[] = { 30, 28, 27, 26, 25, 19, 16, 13, 10 };
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[20];
		visited = new boolean[41];
		for (int i = 0; i < 20; i++) {
			count += 2;
			arr[i] = count;
			System.out.print(arr[i]);
		}

	}

	public static void solve(int x, int depth) {
		if (depth == 10) {

		} else {
			visited[arr[x]] = true;
			
		}
	}

}
