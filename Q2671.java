package study;

import java.util.Scanner;

public class Q2671 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String answer="";
		answer= s.matches("(100+1+|01)+")?"SUBMARINE":"NOISE";
		System.out.println(answer);
		sc.close();
	}

}
