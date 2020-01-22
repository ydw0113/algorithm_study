package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1065 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[4];
		int count = 99;
		int j;
		if (n < 100) {
			System.out.println(n);
		} else if (n < 1000) {
			for (int i = 100; i <= n; i++) {
				j = i;
				arr[0] = j / 100;
				j %= 100;
				arr[1] = j / 10;
				j %= 10;
				arr[2] = j / 1;

				if (arr[0] - arr[1] == arr[1] - arr[2]) {
					count++;
				}
			}
			System.out.println(count);

		} else {

			for (int i = 100; i < n; i++) {
				j = i;
				arr[0] = j / 1000;
				j %= 1000;
				arr[1] = j / 100;
				j %= 100;
				arr[2] = j / 10;
				j %= 10;
				arr[3] = j / 1;
				if (arr[1] - arr[2] == arr[2] - arr[3] ) {
					count++;
				}
			}
			System.out.println(count);
		}

	}

}
