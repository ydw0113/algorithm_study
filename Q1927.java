package study;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1927 {
	static ArrayList<Integer> heap;

	private static void insert(int val) {
		heap.add(val);

		int p = heap.size() - 1;
		while (p > 1 && heap.get(p / 2) > heap.get(p)) {
			int tmp = heap.get(p / 2);
			heap.set(p / 2, heap.get(p));
			heap.set(p, tmp);
			p /= 2;
		}
	}

	private static int delete() {
		if (heap.size() - 1 < 1) {
			return 0;
		}

		int item = heap.get(1);
		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);

		int p = 1;
		while (p * 2 < heap.size()) {
			int min = heap.get(p * 2);
			int minPos = p * 2;
			if ((p * 2 + 1) < heap.size() && heap.get(p * 2 + 1) < min) {
				minPos = p * 2 + 1;
				min = heap.get(p * 2 + 1);
			}
			if (heap.get(p) < min) {
				break;
			}
			int tmp = heap.get(p);
			heap.set(p, min);
			heap.set(minPos, tmp);
			p = minPos;

		}

		return item;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		heap = new ArrayList<>();
		heap.add(0);
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				System.out.println(delete());
			} else {
				insert(arr[i]);
			}
		}

	}

}
