package study;

import java.util.Arrays;

public class Intern_03 {

	public static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		int usize = user_id.length;
		int bsize = banned_id.length;
		int arr[] = new int[bsize];
		boolean visited[] = new boolean[usize];
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
					cnt[i]=user_id[j]; 
					System.out.print(user_id[j]+" ");
					visited[j] = true;
				}
			}
			System.out.println();
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		solution(user_id, banned_id);
	}

}
