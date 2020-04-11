package study;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class hack_02 {
	public int solution(String[] id_list, int k) {
		int answer = 0;
		HashMap<String, Integer> hash = new HashMap<>();
		Set<String> set = new HashSet<>();
		for (String s : id_list) {
			String[] arr = s.split(" ");
			for (String input : arr) {
				if (set.contains(input))
					continue;
				set.add(input);
				if (hash.isEmpty() || !hash.containsKey(input)) {
					answer++;
					hash.put(input, 1);
				} else if (hash.get(input) < k) {
					answer++;
					hash.put(input, hash.get(input) + 1);
				}
			}
			set.clear();
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new hack_02().solution(
				new String[] { "JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY" }, 3));
	}
}