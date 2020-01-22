package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2217 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int max=0;
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int i=n-1; i>=0; i--) {
			if(max<arr[i]*(n-i))
				max=arr[i]*(n-i);
		}
		System.out.println(max);
	}

}
