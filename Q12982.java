package study;

import java.util.Arrays;

public class Q12982 {
	public static int solution(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);
		int count = 0;
		for (int i = 0; i < d.length; i++) {
			if (budget - d[i] > 0) {
				count++;
				budget -= d[i];
			} else
				break;
		}
		System.out.println(count);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d[] = { 1, 3, 2, 5, 4 };
		int budget = 9;
		solution(d, budget);
	}

}
