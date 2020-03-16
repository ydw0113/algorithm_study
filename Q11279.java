package study;

import java.util.ArrayList;
import java.util.Scanner;

public class Q11279 {
	static ArrayList<Integer> heap;
	static int arr[];

	public static void insert(int val) {
		heap.add(val);
		int p = heap.size() - 1;
		while (p > 1 && heap.get(p / 2) < heap.get(p)) {
			int tmp = heap.get(p / 2);
			heap.set(p / 2, heap.get(p));
			heap.set(p, tmp);
			p = p / 2;
		}
	}

	public static int delete() {
		if (heap.size() - 1 < 1) {
			return 0;
		}
		int deleItem = heap.get(1);

		heap.set(1, heap.get(heap.size() - 1));
		heap.remove((heap.size() - 1));

		int pos = 1;
		while (pos * 2 < heap.size()) {
			int max = heap.get(pos * 2);
			int maxPos = pos * 2;
			if ((pos * 2 + 1) < heap.size() && max < heap.get(pos * 2 + 1)) {
				max = heap.get(pos * 2 + 1);
				maxPos = pos * 2 + 1;
			}
			if (heap.get(pos) > max) {
				break;
			}
			int tmp = heap.get(pos);
			heap.set(pos, heap.get(maxPos));
			heap.set(maxPos, tmp);
			pos = maxPos;
		}

		return deleItem;
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
		heap.add(10000000);

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
