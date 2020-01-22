package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n + 1][2];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		int count = 0;
		int end;
		for (int i = 1; i <= n; i++) {
			end = arr[i][0] + i;
			if (i + arr[i][0] < n+1)
			count=arr[i][1];
			for (int j = i; j <= n; j++) {
				if (j == end) {
					if (j + arr[j][0] > n+1)
						break;
					else {
						end = arr[j][0] + j;
						count += arr[j][1];
						System.out.println(i + "  " + j + "  " + count);
					}
				}
			}
			if (max < count)
				max = count;
			count = 0;
		}

		System.out.println(max);

	}

}
