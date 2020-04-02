package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Intern_03 {
	static int sum = 0;
	static ArrayList<String> list[];
	static Set<Set<String>> set = new HashSet<>();
	static Set<String> tmp = new HashSet<>();
	static int answer = 0;

	public static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		int usize = user_id.length;
		int bsize = banned_id.length;
		int arr[] = new int[bsize];
		list = new ArrayList[bsize];
		boolean visited[] = new boolean[usize];
		int count = 0;
		int cnt[] = new int[bsize];
		for (int i = 0; i < bsize; i++) {
			list[i] = new ArrayList<>();
			for (int j = 0; j < banned_id[i].length(); j++) {
				if (banned_id[i].charAt(j) != '*') {
					count++;
				}
			}
			arr[i] = count;
			count = 0;
		}
		for (int i = 0; i < bsize; i++) {
			cnt[i] = 1;
			for (int j = 0; j < bsize; j++) {
				if (i == j)
					continue;
				if (banned_id[i] == banned_id[j])
					cnt[i]++;
			}
		}

		for (int i = 0; i < bsize; i++) {
			Arrays.fill(visited, false);
			for (int j = 0; j < usize; j++) {
				count = 0;
				if (visited[j])
					continue;
				if (user_id[j].length() != banned_id[i].length())
					continue;
				else {
					for (int z = 0; z < banned_id[i].length(); z++) {
						if (user_id[j].charAt(z) == banned_id[i].charAt(z)) {
							count++;
						}
					}
				}
				if (count == arr[i]) {
					// System.out.print(user_id[j] + " ");
					visited[j] = true;
					list[i].add(user_id[j]);
					// break;
				}
			}
			// System.out.println();
		}

		 String[] comArr = new String[bsize];
		 combination(comArr, user_id, usize, bsize, 0, 0,bsize);
//		LinkedList<String> perArr = new LinkedList<String>();
//		int[] perCheck = new int[usize];
//		permutation(user_id, usize, bsize, perArr, perCheck);
		System.out.println(answer);
		return answer;
	}

	 private static void combination(String[] comArr, String[] user_id, int n, int
	 r, int index, int target,int bsize) {
	 if (r == 0) {
	 int idx = 0;
	 int count = 0;
	 for (String i : comArr) {
	 System.out.print(i+" ");
	 if (list[idx].contains(i)) {
	 count++;
	 }
	 idx++;
	 }
	 System.out.println();
	 System.out.println(count);
	 if (count == bsize)
	 sum++;
	 return;
	 }
	 if (target == n)
	 return;
	
	 comArr[index] = user_id[target];
	 combination(comArr, user_id, n, r - 1, index + 1, target + 1,bsize);// 뽑는경우
	 combination(comArr, user_id, n, r, index, target + 1,bsize);// 안뽑는경우
	 }
//	private static void permutation(String[] user_id, int n, int r, LinkedList<String> perArr, int[] perCheck) {
//		if (tmp.size() == r) {
//			int idx = 0;
//			int count = 0;
//			if (set.isEmpty() || !set.contains(tmp)) {
//				System.out.println(tmp);
//				answer++;
//				set.add(tmp);
//				System.out.println("add");
//			}
//			return;
//		}
//
//		for (int i = 0; i < n; i++) {
//			if (perCheck[i] == 0) {
//				tmp.add(user_id[i]);
//				perCheck[i] = 1;
//				permutation(user_id, n, r, perArr, perCheck);
//				perCheck[i] = 0;
//				tmp.remove(user_id[i]);
//			}
//		}
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		solution(user_id, banned_id);
	}

}