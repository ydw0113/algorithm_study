package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class lms_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if (tmp == 1) {
				list.add(i + 1);
			}
		}
		int max = 0;
		int idx = 0;
		int idx2 = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			if (max < list.get(i + 1) - list.get(i)) {
				idx = list.get(i + 1);
				idx2 = list.get(i);
				max = list.get(i + 1) - list.get(i);
			}
		}
		System.out.println(max + " " + idx + " " + idx2);
		int answer = 0;
		if (list.size() == 1) {
			answer = Math.max(n - list.get(0),list.get(0)-1);
		
		}
		else if (idx - idx2 == 1)
			answer = 1;
		else
			answer = max / 2;

		System.out.println(answer);
		sc.close();
	}
}
