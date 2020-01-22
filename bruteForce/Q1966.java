package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1966 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		while (t > 0) {
			int count = 0;
			LinkedList<Integer> pr = new LinkedList<Integer>();
			Queue<Integer> q = new LinkedList<Integer>();
			boolean flag = true;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				pr.add(tmp);
			}

			for (int i = 0; i < n; i++)
				q.add(i);
			int a = 0;
			while (!q.isEmpty()) {
				flag = true;
				for (int i = a; i < q.size(); i++) {
					if (pr.get(a) < pr.get(i)) {
						int tmp = pr.poll();
						pr.offer(tmp);
						tmp = q.poll();
						q.offer(tmp);

						flag = false;
						break;

					}
				}
				if (flag) {
					count++;
					pr.poll();
					int check = q.poll();
					if (check == k) {
						System.out.println(count);
						break;
					}
				}
			}
			t--;
		}
	}

}
