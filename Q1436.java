package study;

import java.util.Scanner;

public class Q1436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = 0;
		while (n > 0) {
			num++;
			String s = Integer.toString(num);
			if (s.contains("666"))
				n--;
		}
		System.out.println(num);

	}

}