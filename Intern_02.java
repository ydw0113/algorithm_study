package study;

import java.util.ArrayList;

public class Intern_02 {

	public static int[] solution(String s) {
		ArrayList<Integer> list[];
		ArrayList<Integer> t[];
		int[] answer = {};
		String a = s.substring(1, s.length() - 1);
		String words[] = a.split("\\{");
		list = new ArrayList[words.length];
		for (int i = 0; i < words.length; i++) {
			list[i] = new ArrayList<Integer>();
			String[] tmp = words[i].split("[^A-Z0-9]+|[^0-9$]");
			for (int j = 0; j < tmp.length; j++) {
				if (tmp[j].equals(""))
					continue;
				list[i].add(Integer.parseInt(tmp[j]));
			}
		}
		t = new ArrayList[words.length];
		ArrayList<Integer> li = new ArrayList<>();
		int cnt[] = new int[words.length-1];

		for (int i = 1; i < words.length; i++) {
			t[i] = new ArrayList<Integer>();
			for (int j = 1; j < words.length; j++) {
				if (list[j].size() == i)
					for (int z : list[j])
						t[i].add(z);
			}
		}

		for (int i = 1; i < words.length; i++) {
			for (int j : t[i]) {
				if (!li.contains(j))
					li.add(j);
			}
		}

		for (int i = 0; i < li.size(); i++) {
			cnt[i] = li.get(i);
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		solution(s);
	}

}
