package study;

import java.util.Arrays;
import java.util.Scanner;

public class Q1449 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int L = scan.nextInt() - 1;
		int[] arr = new int[1001];
		int count = 0;
		Arrays.fill(arr, 0);
		for (int i = 0; i < n; i++) {
			arr[scan.nextInt()] = 1;
		}
//		Arrays.sort(arr);

		for (int i = 0; i <= 1000; i++) {
			if (arr[i] == 1) {
				count++;
				for (int j = i; j <= i + L; j++) {
					if (j == 11001)
						break;
					arr[j] = 0;
				}
			}
		}

		System.out.println(count);
		scan.close();
	}

}
