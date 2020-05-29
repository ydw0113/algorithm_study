package study;

import java.util.Scanner;

public class Q2745 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int b = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			if ('0' <= n.charAt(i) && n.charAt(i) <= '9') {
				sum = sum * b + ((int) n.charAt(i) - (int) '0');
			} else {
				sum = sum * b + ((int) n.charAt(i) - (int) 'A' + 10);
			}
		}
		System.out.println(sum);

	}

}
