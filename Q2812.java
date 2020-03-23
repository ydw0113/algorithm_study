package study;

import java.util.Scanner;
import java.util.Stack;

public class Q2812 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String number = sc.next();
		char[] result = new char[number.length() - k];
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = stack.get(i);
		}
		System.out.println(result);
		sc.close();
	}

}
