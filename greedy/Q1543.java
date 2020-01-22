package study;

import java.util.Scanner;

public class Q1543 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String s2 = sc.nextLine();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			String tmp = s.substring(i);
			if (tmp.startsWith(s2) && tmp.length() >= s2.length()) {
				count++;
				i += s2.length()-1;
			}
		}
		System.out.println(count);
		sc.close();
	}

}
