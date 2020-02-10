package study;

import java.util.Scanner;

public class Q9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long arr[] = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		arr[6] = 3;
		arr[7] = 4;
		arr[8] = 5;
		arr[9] = 7;
		arr[10] = 9;
		while (n > 0) {
			int p = sc.nextInt();
			if (p <= 10) {
				System.out.println(arr[p]);
			} else {
				for (int i = 10; i < p; i++) {
					arr[i+1] = arr[i] + arr[i - 4];
				}
				System.out.println(arr[p]);
			}

			n--;
		}
	}

}
