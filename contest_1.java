package study;

import java.util.Scanner;

public class contest_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Long t = sc.nextLong();
		long cnt = 0;
		long cnt2 = 0;
		StringBuilder sb = new StringBuilder();
		while (t > 0) {
			long n = sc.nextLong();
			if (n % 2 == 0) {
				cnt++;
			} else
				cnt2++;
			t--;
		}
		if (cnt2 <= cnt)
			sb.append("O");
		else
			sb.append("E");
		System.out.print(sb);
		sc.close();
	}

}
