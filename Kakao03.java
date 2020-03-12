package study;

import java.util.LinkedList;

public class Kakao03 {
	public static int Kakao03(String str1, String str2) {
		int answer = 0;
		String s = "";
		String s2 = "";
		LinkedList<String> list = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		for (int i = 0; i < str1.length(); i++) {
			char t = str1.charAt(i);
			if (65 <= t && t <= 90) {
				s += str1.substring(i, i + 1);
			} else if (97 <= t && t <= 122) {
				s += str1.substring(i, i + 1);
			} else
				continue;
		}
		for (int i = 0; i < str2.length(); i++) {
			char t = str2.charAt(i);
			if (65 <= t && t <= 90) {
				s2 += str2.substring(i, i + 1);
			} else if (97 <= t && t <= 122) {
				s2 += str2.substring(i, i + 1);
			} else
				continue;
		}

		for (int i = 0; i < s.length() - 1; i++) {
			String tmp = s.substring(i, i + 2).toLowerCase();
			list.add(tmp);
		}

		for (int i = 0; i < s2.length() - 1; i++) {
			String tmp = s2.substring(i, i + 2).toLowerCase();
			list2.add(tmp);
		}
		int count = 0;
		for (String i : list) {
			for (String j : list2) {
				if (i.equals(j)) {
					count++;
					break;
				}
			}
		}
		int count2 = 0;
		for (String i : list) {
			for (String j : list2) {
				if (i.equals(j)) {
					count++;
					break;
				}
			}
		}
		double t;
		if (count == 0)
			t = 1;
		else
			t = ((double) count / (double) (list.size() + list2.size() - count));
		answer = (int) (t * 65536);
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "handshake";
		String s2 = "shake hands";
		Kakao03(s, s2);
	}

}
