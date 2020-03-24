package study;

import java.util.Arrays;
import java.util.Collections;

public class Solution_boat {
	public static int solution(int[] people, int limit) {
		int answer = 1;
		boolean visited[] = new boolean[people.length];
		Arrays.sort(people);
		int sum = 0;
        int index=0;
		for (int i = people.length - 1; i > 0; i--) {
            if(visited[i])
                break;
			sum = people[i];
			visited[i] = true;
			for (int j = index; j < people.length; j++) {
				if (!visited[j]) {
					if (limit - (sum + people[j]) < 0) {
						answer++;
						break;
					} else {
                        visited[j]=true;
                        index++;
						sum += people[j];
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 70, 50, 80, 50 };
		solution(a, 100);
	}

}
