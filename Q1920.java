package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920 {
	static int arr[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int k = Integer.parseInt(st.nextToken());
			System.out.println(bin(0, n - 1, k));
		}
	}

	public static int bin(int left, int right, int k) {
		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] > k) {
				right = mid - 1;
			} else if (arr[mid] < k) {
				left = mid + 1;
			} else if (arr[mid] == k) {
				return 1;
			}
		}
		return 0;
	}
}
