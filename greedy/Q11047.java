package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int i = n - 1;
		int sum = 0;
		int count = 0;
		while (k>0) {
			if (k / arr[i] > 0) {
				count = k / arr[i];
				sum += count;
				k%=arr[i];
				count = 0;
			}
			i--;
		}
		System.out.println(sum);
	}

}
