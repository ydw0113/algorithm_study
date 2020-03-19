package study;

import java.math.BigInteger;
import java.util.Scanner;

public class Q1914 {
	static void hanoi(int N, char from, char aux, char to) {
		if (N == 1) {
			System.out.println(from + " " + to);
		} else {
			hanoi(N - 1, from, to, aux);
			System.out.println(from + " " + to);
			hanoi(N - 1, aux, from, to);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger result = new BigInteger("1");
		if (N == 1)
			System.out.println(1);
		else {
			for (int i = 0; i < N; i++) {
				result = result.multiply(new BigInteger("2"));
			}
			result = result.subtract(new BigInteger("1"));
			System.out.println(result);
		}
		if (N <= 20) {
			hanoi(N, '1', '2', '3');
		}
	}

}
