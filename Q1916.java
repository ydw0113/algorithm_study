package study;

import java.util.*;
import java.io.*;

public class Q1916 {
	static final int INF = 987654321;
	static int n, m;
	static int[] dist;
	static List<List<Node>> list;

	static class Node implements Comparable<Node> {
		int index, distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());

		dist = new int[n + 1];
		list = new ArrayList<List<Node>>();
		list.add(new ArrayList<Node>());

		Arrays.fill(dist, INF);
		for (int i = 1; i <= n; i++) {
			list.add(new ArrayList<Node>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list.get(v1).add(new Node(v2, cost));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(list, dist, start);
		System.out.println(dist[end]);
	}

	static void dijkstra(List<List<Node>> list, int[] distance, int start) {
		boolean[] visited = new boolean[n + 1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		distance[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			int now = pq.poll().index;

			if (visited[now])
				continue;
			visited[now] = true;

			for (Node node : list.get(now)) {
				if (distance[node.index] > distance[now] + node.distance) {
					distance[node.index] = distance[now] + node.distance;
					pq.add(new Node(node.index, distance[node.index]));
				}
			}
		}
	}

}