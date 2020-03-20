package study;

import java.util.Collections;
import java.util.LinkedList;

public class L1 {
	public long solution(long n) {
		long answer = 0;
		String s = Long.toString(n);
		LinkedList<Long> li = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			String tmp = s.substring(i, i + 1);
			li.add(Long.parseLong(tmp));
		}
		Collections.sort(li, Collections.reverseOrder());
		s = "";
		for (long a : li)
			s += Long.toString(a);
		answer = Long.parseLong(s);
		return answer;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
