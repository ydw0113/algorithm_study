package algori;

import java.util.Scanner;

public class Q7568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[][] = new int[n][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++)
				arr[i][j] = sc.nextInt();
		}
		int count[] = new int[n];
		for (int i = 0; i < n; i++) {
			count[i] = 1;
			for (int j = 0; j < n; j++) {
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					count[i]++;
				}
			}
		}
		for(int i=0; i<n; i++)
			System.out.print(count[i]+" ");

	}

}
