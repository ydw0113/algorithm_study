package study;

import java.util.*;

public class Q14503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] flag = new boolean[n + 2][m + 2];
		int[][] box = new int[n + 2][m + 2];
		int count = 0;
		int c = sc.nextInt();
		int r = sc.nextInt();
		int d = sc.nextInt();
		int tmpR, tmpC;
		int tmp = 0;
		int tmpD=d;
		int count1=0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				box[i][j] = sc.nextInt();
				if (box[i][j] == 1)
					flag[i][j] = false;
				else
					flag[i][j] = true;
			}
		}
		box[r][c] = 1;
		count++;
		while (true) {
			tmpR = r;
			tmpC = c;
//			if(tmp==0)
//			tmpD = d;
			System.out.println(" c =" + c + "r = " + r + " d = " + d);
			if (r == 0 || c == 0 || r >= n || c >= m) {
				break;
			}
			if (d == 0) {
				if (box[r][c - 1] == 0) {
					c = c - 1;
					d = 3;
				} else {
					d = 3;
					tmp++;
				}
			} else if (d == 1) {
				if (box[r - 1][c] == 0) {
					r = r - 1;
					d = 0;
				} else {
					d = 0;
					tmp++;
				}

			} else if (d == 2) {
				if (box[r][c + 1] == 0) {
					c = c + 1;
					d = 1;
				} else {
					d = 1;
					tmp++;
				}
			} else if (d == 3) {
				if (box[r + 1][c] == 0) {
					r = r + 1;
					d = 2;
				} else {
					d = 2;
					tmp++;
				}
			}
			if (tmpR != r || tmpC != c) {
				tmp = 0;
				box[r][c] = 1;
				count++;
				System.out.println("count== "+count);
			}

			if (tmp == 4) {
//				d=tmpD;
				tmp = 0;
				if (d == 0) {
					if (flag[r + 1][c]) {
						r = r + 1;
						tmpR = r;
						d = 0;
					} else if(!flag[r+1][c]) {
						break;
					}
				} else if (d == 1) {
					if (flag[r][c - 1]) {
						c = c - 1;
						tmpC = c;
						d = 1;
					} else if(!flag[r][c-1]) {
						break;
					}

				} else if (d == 2) {
					if (flag[r - 1][c]) {
						r = r - 1;
						tmpR = r;
						d = 2;
					} else if(!flag[r-1][c]) {
						break;
					}
				} else if (d == 3) {
					if (flag[r][c + 1]) {
						c = c + 1;
						tmpC = c;
						d = 3;
					} else if(!flag[r][c+1]) {
						break;
					}
				}
			}
		}
		
		System.out.println(count);
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if(flag[i][j] && box[i][j]==1)
					count1++;
				System.out.print(box[i][j]);
			}
			System.out.println();
		}
		System.out.println(count1);
	}

}