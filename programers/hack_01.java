package study;

import java.util.Arrays;
import java.util.HashMap;

public class hack_01 {

	public static String solution(int n, int[][] delivery) {
		String answer = "";
		HashMap<Integer, String> hash = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			hash.put(i, "?");
		}
		Arrays.sort(delivery,(o1,o2)->o2[2]- o1[2]);
		
		for (int i = 0; i < delivery.length; i++) {
			for (int j = 0; j < delivery[i].length; j++) {
				if (delivery[i][2] == 1) {
					hash.put(delivery[i][0], "O");
					hash.put(delivery[i][1], "O");
				} else if (delivery[i][2] == 0) {
					if (hash.get(delivery[i][0]).equals("O")) {
						hash.put(delivery[i][1], "X");
					} else if (hash.get(delivery[i][1]).equals("O")) {
						hash.put(delivery[i][0], "X");
					}
				}
			}
		}
		for (int i = 1; i <= n; i++)
			answer+=hash.get(i);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int delivery[][] = { { 5, 6, 0 }, { 1, 3, 1 }, { 1, 5, 0 }, { 7, 6, 0 }, { 3, 7, 1 }, { 2, 5, 0 } };
		solution(n, delivery);
	}

}
