package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hanoi {
	static Scanner input = new Scanner(System.in);
	static int n, a, b, c, i, count = 0, j;
	static int[] arr;
	static int[] pow = new int[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[6];
		arr[0] = 0;
		pow[0] = 1;

		for (i = 1; i < 6; i++) {
			pow[i] = (pow[i - 1] * 2);
		}
		for (i = 1; i <= 3; i++) {
			String s = br.readLine();
			String tmp[] = s.split(" ");
			for (int j = 0; j < tmp.length; j++) {
				int t = Integer.parseInt(tmp[j]);
				arr[6 - t] = i;
			}
		}
		hanoi(4, arr[5]);
		System.out.println(count);
	}

	public static void hanoi(int num, int to) {
		int from = arr[num];
		int by = 6 - from - to;
		if (num < 1)
			return;
		if (to != from) {
			hanoi(num - 1, by);
			count = (count + pow[num - 1]);
		} else {
			hanoi(num - 1, to);
		}
	}

}