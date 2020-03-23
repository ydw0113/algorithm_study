package study;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Q8980 {
	static LinkedList<tr> li = new LinkedList<tr>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int arr[][] = new int[n + 1][n + 1];
		int clone[][] = new int[n + 1][n + 1];
		int m = sc.nextInt();
		int sum = 0;
		int answer = 0;
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			li.add(new tr(x, y, d));
		}
		Collections.sort(li, new Comparator<tr>() {
			@Override
			public int compare(tr s1, tr s2) {
				if (s1.y < s2.y) {
					return -1;
				} else if (s1.y > s2.y) {
					return 1;
				} else if (s1.y == s2.y) {
					if (s1.x < s2.x)
						return -1;
				}
				return 0;
			}
		});
		for (tr i : li) {
			
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				sum -= clone[i][j];
				clone[i][j] = 0;
				if (sum + arr[i][j] > c) {
					int tmp = c - sum;
					sum = c;
					answer += tmp;
					clone[j][i] = tmp;
				} else {
					clone[j][i] = arr[i][j];
					sum += arr[i][j];
					answer += arr[i][j];
				}

			}
		}
		System.out.println(answer);

	}
}

class tr {
	int x;
	int y;
	int d;

	public tr(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}