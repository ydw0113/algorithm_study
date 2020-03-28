package study;

import java.util.ArrayList;
import java.util.Arrays;

public class Intern_04 {

	public static long[] solution(long k, long[] room_number) {
		boolean visited[];
		long[] answer = new long[room_number.length];
		visited = new boolean[(int) k+1];
		Arrays.sort(room_number);
		for (int i = 0; i < room_number.length; i++) {
			if (visited[(int) room_number[i]]) {
				for (int j = (int) room_number[i]; j <=k; j++) {
					if (!visited[j]) {
						visited[j] = true;
						answer[i] = j;
						break;
					}
				}

			} else {
				answer[i] = room_number[i];
				visited[(int) room_number[i]] = true;
			}

		}

		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 10;
		long[] room_number = { 1, 3, 4, 1, 3, 1 };
		solution(k, room_number);
	}

}
