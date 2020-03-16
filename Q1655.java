package study;

import java.io.*;
import java.util.*;

public class Q1655 {
	public static StringTokenizer stk;
	public static StringBuilder sb = new StringBuilder();
	public static PriorityQueue<Integer> minHeap;
	public static PriorityQueue<Integer> maxHeap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		minHeap = new PriorityQueue<>(Comparator.naturalOrder());
		maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if (i == 0) {
				maxHeap.add(num[i]);
				sb.append(num[i] + "\n");
				continue;
			}
			if (i % 2 == 0) {
				maxHeap.add(num[i]);
			} else {
				minHeap.add(num[i]);
			}
			if (changeCheck()) {
				swap();
			}
			sb.append(maxHeap.peek() + "\n");
		}
		System.out.println(sb);
	}

	public static boolean changeCheck() {
		if (minHeap.isEmpty() || maxHeap.isEmpty())
			return false;
		return minHeap.peek() <= maxHeap.peek();
	}

	public static void swap() {
		int minTomax = minHeap.poll();
		int maxTomin = maxHeap.poll();
		minHeap.add(maxTomin);
		maxHeap.add(minTomax);
	}
}
