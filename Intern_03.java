package study;

import java.util.ArrayList;
import java.util.Arrays;

public class Intern_03 {

	public static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		int usize = user_id.length;
		int bsize = banned_id.length;
		int arr[] = new int[bsize];
		ArrayList<Integer> list[] = new ArrayList[bsize];
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
				if (visited[j]) {
					list[i].add(0);
					continue;
				}
				if (user_id[j].length() != banned_id[i].length()) {
					list[i].add(0);
					continue;
				} else {
					for (int z = 0; z < banned_id[i].length(); z++) {
						if (user_id[j].charAt(z) == banned_id[i].charAt(z)) {
							count++;
						}
					}
				}
				if (count == arr[i]) {
					System.out.print(user_id[j] + " ");
					visited[j] = true;
					list[i].add(1);
					// break;
				} else
					list[i].add(0);
			}
			System.out.println();
		}
		int an[][] = new int[bsize][usize];
		for (int i = 0; i < bsize; i++) {
			for (int j = 0; j < usize; j++) {
				an[i][j] = list[i].get(j);
				System.out.print(an[i][j] + " ");
			}
			System.out.println();
		}
		int sum = 0;
		int flag = 0;
		int index = 0;
		for (int i = 0; i < usize; i++) {
			if (an[0][i] == 1) {
				flag = 1;
			} else {
				flag = 0;
			}
			index++;

		}

		System.out.println(sum);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		solution(user_id, banned_id);
	}

}