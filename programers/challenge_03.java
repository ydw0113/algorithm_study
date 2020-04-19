package study;

import java.util.LinkedList;

public class challenge_03 {
	static int min = 10000000;
	static int count = 0;
	static int k = 0;
	static boolean flag;
	static boolean c = false;

	public static int solution(int[] numbers, int K) {
		int answer = 0;
		int n = numbers.length;
		k = K;
		LinkedList<Integer> perArr = new LinkedList<Integer>();
		int[] perCheck = new int[n];
		permutation(n, n, perArr, perCheck, numbers);
//		System.out.println(min);
		if (!c|| min==10000000)
			answer = -1;
		else
			answer = min;
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 2,6,7,4,5 };
		int K = 2;
		solution(numbers, K);
	}

	private static void permutation(int n, int r, LinkedList<Integer> perArr, int[] perCheck, int[] numbers) {
		if (perArr.size() == r) {
			check(perArr, numbers);
			if (flag) {
				if (count % 2 == 0) {
					count /= 2;
				} else {
					count = count / 2 + 1;
				}
				min = Math.min(min, count);
			}
			if (flag)
				c = true;
			count = 0;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (perCheck[i] == 0) {
				perArr.add(numbers[i]);
				perCheck[i] = 1;
				permutation(n, r, perArr, perCheck, numbers);
				perCheck[i] = 0;
				perArr.removeLast();
			}
		}

	}

	private static void check(LinkedList<Integer> perArr, int[] numbers) {
		flag = true;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (k < Math.abs(perArr.get(i) - perArr.get(i + 1))) {
				flag = false;
				break;
			} else {
				if (perArr.get(i) != numbers[i])
					count++;
			}
		}
		if (flag) {
			if (perArr.get(numbers.length - 1) != numbers[numbers.length - 1])
				count++;
		} else
			count = 0;
	}

}
