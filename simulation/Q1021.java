package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1021 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 0, M = 0, result = 0;
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			if (i == 0) {
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				for (int d = 1; d <= N; d++) {
					deque.add(d);
				}
			} else {
				for (int j = 0; j < M; j++) {
					int selectNum = Integer.parseInt(st.nextToken());
					while (true) {
						int idx = 0;
						Iterator<Integer> it = deque.iterator();
						while (it.hasNext()) {
							if (it.next() == selectNum)
								break;
							idx++;
						}
						if (idx == 0) {
							deque.pollFirst();
							break;
						} else if (deque.size() / 2 >= idx) {
							deque.addLast(deque.pollFirst());
							result++;
						} else {
							deque.addFirst(deque.pollLast());
							result++;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}