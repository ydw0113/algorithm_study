package study;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Intern_03 {
	static int sum = 0;
	static ArrayList<String> list[];
	static Set<String> tmp = new HashSet<>();
	static boolean visited[];
	static int arr[];
	static int answer = 0;

	public static int solution(String[] user_id, String[] banned_id) {
		int usize = user_id.length;
		int bsize = banned_id.length;
		arr = new int[bsize];
		visited = new boolean[usize];
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
		String[] comArr = new String[bsize];
		combination(comArr, user_id, banned_id, usize, bsize, 0, 0);
		System.out.println(answer);
		return answer;
	}

	private static void combination(String[] comArr, String[] user_id, String banned_id[], int n, int r, int index,
			int target) {
		if (r == 0) {
			
			if (check(comArr, banned_id))
				answer++;
			return;
		}
		if (target == n)
			return;

		comArr[index] = user_id[target];
		combination(comArr, user_id, banned_id, n, r - 1, index + 1, target + 1);
		combination(comArr, user_id, banned_id, n, r, index, target + 1);
	}

	private static boolean check(String[] comArr, String[] banned_id) {
		int bsize = banned_id.length;
		int count = 0;
		Deque<String> dq = new ArrayDeque<String>();
		for (int i = 0; i < comArr.length; i++)
			dq.add(comArr[i]);

		for (int a = 0; a < dq.size(); a++) {
			tmp.clear();
			Arrays.fill(visited, false);
			for (int i = 0; i < bsize; i++) {
				int j = -1;
				for (String s : dq) {
					j++;
					count = 0;
					if (visited[j])
						continue;
					if (s.length() != banned_id[i].length())
						continue;
					else {
						for (int z = 0; z < banned_id[i].length(); z++) {
							if (s.charAt(z) == banned_id[i].charAt(z)) {
								count++;
							}
						}
					}
					if (count == arr[i]) {
						visited[j] = true;
						tmp.add(s);
						break;
					}
				}
			}
			if (tmp.size() == comArr.length)
				return true;
			String t = dq.poll();
			dq.addLast(t);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		solution(user_id, banned_id);
	}

}