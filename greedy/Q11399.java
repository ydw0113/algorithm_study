package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11399 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int sum = 0;
		int arr[] = new int[n];
		int arr2[] =new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			sum+=arr[i];
			arr2[i]=sum;
		}
		sum=0;
		for (int i = 0; i < n; i++) {
			sum+=arr2[i];
		}
		System.out.println(sum);

	}

}
