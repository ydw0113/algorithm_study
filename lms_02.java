package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class lms_02 {
	static int n, m;
	static int count = 0;
	static LinkedList<Integer> q = new LinkedList<Integer>();
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean visited[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		visited = new boolean[10];
		for (int i = 0; i < 3; i++) {
			int tmp = sc.nextInt();
			list.add(tmp);
		}
		m = sc.nextInt();
		Collections.sort(list);
		solve(0);
		sc.close();
	}

	public static void solve(int depth) {
		if (depth == 3) {
			count++;
			if (count == m) {
				for (int i : q) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			return;
		} else {
			for (int i = 0; i < 3; i++) {
				if (!visited[i]) {
					visited[i] = true;
					q.add(list.get(i));
					solve(depth + 1);
					visited[i] = false;
					q.removeLast();
				}
			}
		}
	}

}
