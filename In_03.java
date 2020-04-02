package study;

import java.util.*;

public class In_03 {
	static String[] users;
	static String[] banUser;
	static ArrayList<String>[] result;
	static Set<String> tmp = new HashSet<>();
	static Set<Set<String>> set = new HashSet<>();
	static int answer = 0;
	static int[] perCheck;

	public int solution(String[] user_id, String[] banned_id) {

		users = user_id;
		banUser = banned_id;
		result = new ArrayList[banned_id.length];
		for (int i = 0; i < banUser.length; i++) {
			result[i] = new ArrayList<>();
			makeList(i);
		}
		System.out.println(Arrays.toString(result));
		System.out.println("-------------------------");
		for (int i = 0; i < result[0].size(); i++) {
			tmp.add(result[0].get(i));
			makeSum(0);
			tmp.remove(result[0].get(i));
		}

		return answer;
	}

	void makeList(int index) {
		String banId = banUser[index];
		List<String> list = new ArrayList<>();
		for (String s : users) {
			if (s.length() != banId.length())
				continue;
			else {
				list.add(s);
				for (int i = 0; i < s.length(); i++) {
					if (banId.charAt(i) == '*')
						continue;
					else if (banId.charAt(i) != s.charAt(i))
						list.remove(s);
				}
			}
		}
		result[index].addAll(list);
	}

	void makeSum(int r) {
		if (r >= result.length - 1) {
			System.out.println(tmp);
			System.out.println(set.contains(tmp));
			if (set.isEmpty() || !set.contains(tmp)) {
				answer++;
				set.add(tmp);
				System.out.println("add");
			}
			return;
		}
		for (int i = 0; i < result[r + 1].size(); i++) {
			if (tmp.contains(result[r + 1].get(i)))
				continue;
			tmp.add(result[r + 1].get(i));
			makeSum(r + 1);
			tmp.remove(result[r + 1].get(i));
		}
	}

	public static void main(String[] args) {
		System.out.println(new In_03().solution(new String[] { "abc121", "abc122", "abc124", "abc123", "frodoc" },
				new String[] { "******", "******" }));
	}
}