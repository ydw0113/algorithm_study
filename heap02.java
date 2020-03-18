package study;

import java.util.Comparator;
import java.util.PriorityQueue;

public class heap02 {
	public static int heap02(int stock, int[] dates, int[] supplies, int k) {
		PriorityQueue<Integer> pq;
		int count = 0;
		int answer = 0;
		int day = 0;
		int tmp = 0;
		pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < k; i++) {

			if (stock == 0) {
				int j = day;
				while (j < dates.length && dates[j] <= i) {
					pq.add(supplies[j]);
					j++;
				}
				day = j;
				count++;
				stock += pq.poll();
			}
			if (stock + i >= k)
				break;
			stock--;
		}
		System.out.println(count);
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stock = 4;
		int[] dates = { 4, 10, 15 };
		int[] supplies = { 20, 5, 10 };
		int k = 30;
		heap02(stock, dates, supplies, k);
	}

}
