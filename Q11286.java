package study;

import java.util.ArrayList;
import java.util.Scanner;

public class Q11286 {
	static ArrayList<Integer> heap;
	static int arr[];

	public static void insert(int val) {
		heap.add(val);
		int p = heap.size() - 1;
		while (p > 1 && Math.abs(heap.get(p / 2)) >= Math.abs(heap.get(p))) {

			if (Math.abs(heap.get(p / 2)) == Math.abs(heap.get(p))) {
				if (heap.get(p / 2) > heap.get(p)) {
					int tmp = heap.get(p / 2);
					heap.set(p / 2, heap.get(p));
					heap.set(p, tmp);
					p /= 2;
				} else
					p /= 2;
			} else {
				int tmp = heap.get(p / 2);
				heap.set(p / 2, heap.get(p));
				heap.set(p, tmp);
				p /= 2;
			}
		}
	}

	public static int delete() {
		if (heap.size() - 1 < 1) {
			return 0;
		}
		int item = heap.get(1);
		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		int p = 1;
		while (p * 2 < heap.size()) {
			int min = Math.abs(heap.get(p * 2));
			int minPos = p * 2;
			if ((p * 2 + 1) < heap.size() && Math.abs(heap.get(p * 2 + 1)) <= min) {
				if (Math.abs(heap.get(p * 2 + 1)) == min) {
					if (heap.get(p * 2 + 1) < heap.get(minPos)) {
						min = Math.abs(heap.get(p * 2 + 1));
						minPos = p * 2 + 1;
					}
				} else {
					min = Math.abs(heap.get(p * 2 + 1));
					minPos = p * 2 + 1;
				}
			}
			if (min > Math.abs(heap.get(p))) {
				break;
			}
			if (Math.abs(heap.get(p)) == min) {
				if (heap.get(p) < heap.get(minPos)) {
					break;
				}
			}
			int tmp = heap.get(p);
			heap.set(p, heap.get(minPos));
			heap.set(minPos, tmp);
			p = minPos;

		}

		return item;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		heap = new ArrayList<>();
		heap.add(0);

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				System.out.println(delete());
			} else {
				insert(arr[i]);
			}
		}

		sc.close();
	}

}
