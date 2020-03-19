package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10868 {
	static int N, M;
	static int list[];
	static int start, end;
	static long tree[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new int[N];

		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}

		int x = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = (int) Math.pow(2, x) * 2;
		tree = new long[size];

		init(1, 0, N - 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			System.out.println(min_num(1, 0, N - 1, start - 1, end - 1));
		}
	}

	static long min_num(int node, int start, int end, int left, int right) {
		if (left > end || right < start) { // 노드를 벗어 났을때
			return Integer.MAX_VALUE;
		}
		if (left <= start && right >= end) { // 마지막 노드일때
			return tree[node];
		}
		int mid = (start + end) / 2;
		return Math.min(min_num(node * 2, start, mid, left, right), min_num(node * 2 + 1, mid + 1, end, left, right)); // 자식
																														// 노드가
																														// 있을때
	}

	static long init(int node, int start, int end) {
		if (start == end)
			return tree[node] = list[start];

		int mid = (start + end) / 2;
		return tree[node] = Math.min(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end)); // 가장 값을 넣어야 하므로, 가장
																									// 작은 값으로 갱신해 준다.
	}
}
