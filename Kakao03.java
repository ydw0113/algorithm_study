package study;

import java.util.LinkedList;

public class Kakao03 {
	public static int Kakao03(String str1, String str2) {
		int answer = 0;
		String s = "";
		String s2 = "";
		int index = 0;
		boolean check = false;
		LinkedList<String> list = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		for (int i = 0; i < str1.length(); i++) {
			s += str1.substring(i, i + 1);
		}
		for (int i = 0; i < str2.length(); i++) {
			s2 += str2.substring(i, i + 1);
		}

		for (int i = 0; i < s.length() - 1; i++) {
			String tmp = s.substring(i, i + 2).toLowerCase();
			check = false;
			for (int j = 0; j < 2; j++) {
				char t = tmp.charAt(j);
				if (65 <= t && t <= 90) {
					continue;
				} else if (97 <= t && t <= 122) {
					continue;
				} else
					check = true;
			}
			if (!check)
				list.add(tmp);
		}

		for (int i = 0; i < s2.length() - 1; i++) {
			String tmp = s2.substring(i, i + 2).toLowerCase();
			check = false;
			for (int j = 0; j < 2; j++) {
				char t = tmp.charAt(j);
				if (65 <= t && t <= 90) {
					continue;
				} else if (97 <= t && t <= 122) {
					continue;
				} else
					check = true;
			}
			if (!check)
				list2.add(tmp);
		}
		int count = 0;
		boolean visited[] = new boolean[list2.size()];
		for (String i : list) {
			index = 0;
			for (String j : list2) {
				if (!visited[index]) {
				if (i.equals(j)) {
					 System.out.print(i+" ");
					visited[index] = true;
					count++;
					break;
				}}
				index++;
			}
		}

		double t;
		if (list.size() == 0 && list2.size() == 0) {
			t = 1;
		} else
			t = ((double) count / (double) (list.size() + list2.size() - count));

		answer = (int) (t * 65536);
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "FRANCE";
		String s2 = "french";
		Kakao03(s, s2);
	}

}
