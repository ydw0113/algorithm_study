package study;

import java.util.*;

public class Q1005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b, c, answer = 0;
		int a[] = new int[2];
		int max = 0;
		int tmp = 0;
		int tmp2 = 0;
		int tmp3 = 0;
		while (n > 0) {
			b = sc.nextInt();
			c = sc.nextInt();
			boolean flag[] = new boolean[c + 1];
			for (int i = 0; i < flag.length; i++)
				flag[i] = true;
			int build[] = new int[c + 1];
			for (int i = 1; i <= c; i++) {
				build[i] = sc.nextInt();
			}
			for (int i = 0; i < b; i++) {
				a[0] = sc.nextInt();
				a[1] = sc.nextInt();
				if (flag[a[0]]) {
					if (i != 0) {
						
					}
					tmp = a[0];
					answer += build[1];
					answer += build[a[1]];
					flag[a[0]] = false;
					flag[a[1]] = false;
					tmp2 = build[a[1]];
				} else if (!flag[a[0]]) {
					if (build[a[1]] <= tmp2) {
						if (flag[a[1]]) {
							answer += build[a[1]];
							flag[a[1]] = false;
						}
					} else if (build[a[1]] > tmp2) {
						if (flag[a[1]]) {
							answer -= tmp2;
							answer += build[a[1]];
							tmp2 = build[a[1]];
							flag[a[1]] = false;
						}
					}
				} else if (flag[a[1]]) {
					tmp = a[0];
					answer += build[a[1]];
					System.out.println("i = " + i + " " + answer);
					tmp2 = build[a[1]];
					flag[a[1]] = false;
				}
			}
			System.out.println(answer);
			b = sc.nextInt();
			n--;
		}
	}

}
