package study;

import java.util.Scanner;

public class Q2017_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean answer[][] = new boolean[n][n];
		int arr[] = new int[n];
		boolean flag[] = new boolean[n];
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			answer[x][y] = true;
			arr[x]++;
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] == 1) {
				for (int j = 0; j < n; j++) {
					if (answer[i][j])
						flag[i] = true;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
			System.out.println(arr[i]);
		}

	}

}
