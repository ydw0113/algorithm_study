package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {

	static int arr[], cal[], sum = 0, n;
	static int size = 0;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		cal = new int[4];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
			size += cal[i];
		}
		int min = 1000000000;
		int max = -1000000000;

		// int index = 0;
		// for (int i = 0; i < size; i++) {
		// for (int j = 0; j < 4; j++) {
		// if (cal[j] > 0) {
		// index = j;
		// cal[j] -= 1;
		// break;
		// }
		// }
		// calc(i, index);
		// }
//		System.out.println(sum);
//		System.out.println(max);
//		System.out.println(min);
		solve(1, arr[0]);
	}

	static void solve(int start, int sum) {

		for (int i = 0; i < 4; i++) {
			if (cal[i] > 0) {
				cal[i]--;
				if (i == 0) {
					solve(start + 1, sum + arr[i]);
					break;

				} else if (i == 1) {
					solve(start + 1, sum - arr[i]);
					break;

				} else if (i == 2) {
					solve(start + 1, sum / arr[i]);
					break;

				} else if (i == 3) {
					solve(start + 1, sum * arr[i]);
					break;
				}
			}
			cal[i]++;
		}
		if (start == n) {
			for(int i=0; i<n;i++)
				System.out.print(arr[i]+ " ");
//			sum = 0;
			System.out.println(sum);
		}

	}

}
