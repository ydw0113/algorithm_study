package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q1477 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		while (m > 0) {
			Collections.sort(arr);
			int max = 0;
			int index = 0;
			for (int i = 0; i < arr.size() - 1; i++) {
				if (max < arr.get(i + 1) - arr.get(i)) {
					max = arr.get(i + 1) - arr.get(i);
					index = i;
				}
			}
			// System.out.println(Math.ceil((float)max/2));
			int tmp = (int) Math.ceil((float) max / 2);
			System.out.println(tmp + " " + arr.get(index) + " " + arr.get(index + 1) + " " + (tmp + arr.get(index)));
			arr.add(tmp + arr.get(index));
			m--;
			System.out.println(max);
		}

		Collections.sort(arr);
		int max = 0;
		for (int i = 0; i < arr.size() - 1; i++) {
			if (max < arr.get(i + 1) - arr.get(i)) {
				max = arr.get(i + 1) - arr.get(i);
			}
		}
		System.out.println(max);
		for (int a : arr) {
			System.out.print(a+" ");
		}

		sc.close();
	}

}
