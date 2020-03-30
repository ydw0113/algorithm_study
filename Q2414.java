package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2414 {
	static int n, m;
	static boolean visited[];
	static int arr[];
	static ArrayList<Integer> list[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String s;
		arr = new int[1001];
		visited = new boolean[1001];
		list = new ArrayList[1001];
		int num = 1;
		int an[][] = new int[n + 1][n + 1];
		int an2[][] = new int[n + 1][n + 1];
		String[][] board = new String[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
			s = br.readLine();
			String word[] = s.split("");
			for (int j = 0; j < word.length; j++) {
				if (word[j].equals("*")) {
					board[i][j + 1] = "*";
					an[i][j + 1] = num;
				} else if (j == n - 1 || j == 0) {
					board[i][j + 1] = ".";
					continue;
				} else {
					board[i][j + 1] = ".";
					if (word[j].equals(word[j - 1]))
						continue;
					num++;
				}
			}
			num++;
		}
		int t = num;
		num = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (board[j][i].equals("*")) {
					an2[j][i] = num;
				} else if (j == n - 1 || j == 0) {
					continue;
				} else {
					if (board[j][i].equals(board[j - 1][i]))
						continue;
					num++;
				}
			}
		}
		if (t < num) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (an[i][j] != 0)
						list[i].add(an[i][j]);
				}
			}
		} else {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (an2[i][j] != 0)
						list[i].add(an[i][j]);
				}
			}
		}

		Arrays.fill(arr, 0);
		int count = 0;
		for (int i = 1; i <= n; i++) {
			Arrays.fill(visited, false);
			if (dfs(i))
				count++;

		}
		System.out.println(count);
	}

	public static boolean dfs(int x) {
		int size = list[x].size();
		for (int i = 0; i < size; i++) {
			int tmp = list[x].get(i);
			if (visited[tmp])
				continue;
			visited[tmp] = true;
			if (arr[tmp] == 0 || dfs(arr[tmp])) {
				arr[tmp] = x;
				return true;
			}
		}
		return false;
	}

}
