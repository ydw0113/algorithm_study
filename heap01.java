package study;

import java.util.Comparator;
import java.util.PriorityQueue;

public class heap01 {
	static PriorityQueue<Integer> minHeap;

	public static int heap01(int[] scoville, int K) {
		int answer = 0;
		minHeap = new PriorityQueue<>(Comparator.naturalOrder());
		for (int i = 0; i < scoville.length; i++) {
			minHeap.add(scoville[i]);
		}
		int tmp;
		boolean check = false;
		while (true) {
			if (minHeap.size() == 1) {
				if (minHeap.poll() <= K)
					return answer;
				else
					return -1;
			}
			check = false;
			for (int i : minHeap) {
				if (i <= K) {
					check = true;
					break;
				}
			}
			if (check) {
				tmp = minHeap.poll() + (minHeap.poll() * 2);
				minHeap.add(tmp);
				answer++;
			} else
				break;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n[] = { 1, 2, 3, 9, 10, 12 };
		heap01(n, 7);
	}

}
