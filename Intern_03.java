package study;

import java.util.ArrayList;
import java.util.Arrays;

public class Intern_03 {
	static int n, m;
	static boolean flag[];
	static int an[];
	static ArrayList<Integer> list[];

	public static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		int usize = user_id.length;
		int bsize = banned_id.length;
		int arr[] = new int[bsize];
		boolean visited[] = new boolean[usize];

		an = new int[usize];
		flag = new boolean[usize];
		list = new ArrayList[bsize];
		for (int i = 0; i < bsize; i++)
			list[i] = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < bsize; i++) {
			for (int j = 0; j < banned_id[i].length(); j++) {
				if (banned_id[i].charAt(j) != '*') {
					count++;
				}
			}
			arr[i] = count;
			count = 0;
		}
		String cnt[] = new String[bsize];
		for (int i = 0; i < bsize; i++) {
			Arrays.fill(visited, false);
			for (int j = 0; j < usize; j++) {
				count = 0;
				if (visited[j])
					continue;
				if (user_id[j].length() != banned_id[i].length()) {
					continue;
				} else {
					for (int z = 0; z < banned_id[i].length(); z++) {
						if (user_id[j].charAt(z) == banned_id[i].charAt(z)) {
							count++;
						}
					}
				}
				if (count == arr[i]) {
					cnt[i] = user_id[j];
					list[i].add(j);
					System.out.print(user_id[j] + " ");
					visited[j] = true;
//					break;
				}
			}
			System.out.println();
		}
		for (int i = 0; i < bsize; i++) {
			for (int j : list[i])
				System.out.print(j + " ");
			System.out.println();
		}
		
		Arrays.fill(an, -1);
		int cn = 0;
		for (int i = 0; i < bsize; i++) {
			Arrays.fill(flag, false);
			if (dfs(i))
				cn++;
		}
		System.out.println(cn);

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		solution(user_id, banned_id);
	}

	public static boolean dfs(int x) {
		int size = list[x].size();
		for (int i = 0; i < size; i++) {
			int tmp = list[x].get(i);
			if (flag[tmp])
				continue;
			flag[tmp] = true;
			if (an[tmp] == -1 || dfs(an[tmp])) {
				an[tmp] = x;
				return true;
			}
		}
		return false;
	}
}
