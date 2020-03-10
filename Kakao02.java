package study;

public class Kakao02 {
	public static String Kakao02(String p) {
		String answer = "";
		int cnt1 = 0;
		int cnt2 = 0;
		String u;
		String v;
		for (int i = 0; i < p.length(); i++) {
			char tmp = p.charAt(i);
			if (tmp == '(') {
				cnt1++;
			} else
				cnt2++;
		}
		System.out.println(cnt1 + "   " + cnt2);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ")(";
		Kakao02(s);
	}

}
