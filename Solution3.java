package study;

import java.util.LinkedList;

public class Solution3 {
	static public int[] Solution3(int[] progresses, int[] speeds) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int[] arr = new int[progresses.length];
		int[] days = new int[progresses.length];
		int count = 1;
		for (int i = 0; i < progresses.length; i++) {
			arr[i] = 100 - progresses[i];
			days[i] = arr[i] / speeds[i];
			if (arr[i] % speeds[i] > 0)
				days[i] += 1;
			System.out.println(days[i]);
		}
		int tmp = days[0];
		for (int i = 1; i < days.length; i++) {
			if (tmp >= days[i]) {
				count++;
				if (i == days.length - 1)
					list.add(count);
			} else {
				list.add(count);
				tmp = days[i];
				count = 1;
				if (i == days.length - 1)
					list.add(count);
			}
		}
		int[] answer = new int[list.size()];
		int j = 0;
		for (int a : list) {
			answer[j] = a;
			j++;
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		Solution3(progresses, speeds);
	}

}
