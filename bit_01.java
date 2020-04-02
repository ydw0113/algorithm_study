package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bit_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int sum = 0;
		int count = 0;
		for (int i = 1; i < (1 << n); i++) {
			sum = 0;
//			 System.out.println(i + " " + Integer.toBinaryString(i));
			for (int j = 0; j < n; j++) {
				if ((1 & i >> j) == 0)
					continue;
				 System.out.print(arr[n - 1 - j]+" ");
				sum += arr[n - 1 - j];
			}
			System.out.println();
			if (sum == s)
				count++;
		}
		System.out.println(count);
	}

}
