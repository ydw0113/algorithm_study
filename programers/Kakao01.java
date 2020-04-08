package study;

public class Kakao01 {
	public static int Kakao01(String s) {
		int answer = 0;
		String tmp;
		String dp = "";
		int min = 1001;
		int count = 0;
		if (s.length() == 1)
			return 1;

		for (int i = 1; i <= s.length(); i++) {
			tmp = s.substring(0, i);
			for (int j = 0; j <= s.length();) {
				if (j + i > s.length()) {
					if (j == s.length()) {
						if (count > 1)
							dp += Integer.toString(count) + tmp;
						else
							dp += tmp;
					} else {
						if (count > 1)
							dp += Integer.toString(count) + tmp;
						else
							dp += tmp;
						dp += s.substring(j, s.length());
					}
					break;
				}
				if (tmp.equals(s.substring(j, j + i))) {
					count++;
					if (j == s.length() - 1) {
						dp += Integer.toString(count) + tmp;
						break;
					}
				} else {
					if (count > 1)
						dp += Integer.toString(count) + tmp;
					else
						dp += tmp;
					if (j + i >= s.length()) {
						dp += s.substring(j, s.length());
						break;
					}
					count = 1;
					tmp = s.substring(j, j + i);
				}
				j += i;
			}
			if (dp.length() == 0)
				continue;
			min = Math.min(min, dp.length());
			count = 0;
			dp = "";
		}
		System.out.println(min);

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcdede";
		Kakao01(s);
	}

}
