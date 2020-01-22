package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5585 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int arr[] = new int[6];
		int a = 500;
		arr[0] = 500;
		arr[1] = 100;
		arr[2] = 50;
		arr[3] = 10;
		arr[4] = 5;
		arr[5] = 1;
		int result = 1000 - n;
		int count = 0;
		for (int i = 0; i < 6; i++) {
			count += result / arr[i];
			System.out.println(count + "  " + result + " 동전" + arr[i]);
			result = result % arr[i];
		}
		System.out.println(count);

	}

}
