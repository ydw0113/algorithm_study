package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2252 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n + 1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; i++)
			list.add(new ArrayList<Integer>());

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.get(x).add(y);
			arr[y]++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (arr[i] == 0) {
				q.add(i);
			}
		}
		
		while (!q.isEmpty()) {
			int tmp = q.poll();
			System.out.print(tmp + " ");
			for (int i = 0; i < list.get(tmp).size(); i++) {
				int next = list.get(tmp).get(i);
				arr[next]--;
				if (arr[next] == 0)
					q.add(next);
			}
		}

		sc.close();
	}

}
