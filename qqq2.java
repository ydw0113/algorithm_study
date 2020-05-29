package study;

import java.util.*;
import java.math.*;

public class qqq2 {
	static int l;

	public static int[] multiplicities(int prime[], int N) {
		int i, j;
		int[] primemul = new int[l];
		for (i = 0; i < l; i++)
			primemul[i] = 0;
		for (j = 2; j <= N; j++) {
			int temp = j;
			while (temp > 1) {
				for (i = 0; i < l; i++) {
					if (temp % prime[i] == 0) {
						temp = temp / prime[i];
						primemul[i]++;
					}
				}
			}
		}
		return primemul;
	}

	public static void result(int primemul[]) {
		int i, j;
		BigInteger res = BigInteger.valueOf(1);
		for (i = 0; i < l; i++) {
			j = (2 * primemul[i]) + 1;
			res = res.multiply(BigInteger.valueOf(j));
		}
		res = res.mod(BigInteger.valueOf(1000007));
		System.out.println(res);
	}

	public static int[] primes(int N) {
		int[] prime = new int[N];
		int i, j;
		int f;
		prime[0] = 2;
		l = 1;
		for (i = 3; i <= N; i++) {
			f = 0;
			for (j = 2; j < i; j++) {
				if (i % j == 0)
					f = 1;
			}
			if (f == 0) {
				prime[l] = i;
				l++;
			}
		}
		return prime;
	}

	public static void main(String arg[]) {
		try {
			int N;
			Scanner scan = new Scanner(System.in);
			N = scan.nextInt();
			int prime[] = primes(N);
			int primemul[] = multiplicities(prime, N);
			result(primemul);
		} catch (Exception e) {
		}
	}
}