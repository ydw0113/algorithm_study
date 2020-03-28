package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2512 {

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
		boolean flag = false;

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		int tmp = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] * (n - i) > M) {
				tmp = M / (n - i);
				flag = true;
				break;
			} else {
				M -= arr[i];
			}
		}
		if (flag)
			System.out.println(tmp);
		else
			System.out.println(arr[n - 1]);

	}

}
