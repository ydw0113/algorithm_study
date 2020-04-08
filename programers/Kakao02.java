package study;

public class Kakao02 {

	static int t = 0;
	static boolean flag = false;
	static boolean co = false;

	public static String Kakao02(String p) {
		if (p.equals(""))
			return p;
		String answer = "";
		boolean uF = false;
		String w = p;
		t = 0;
		char tmp;
		flag = false;
		uF = false;
		String u = "";
		String v = "";
		co = false;
		int cnt1 = 0;
		int cnt2 = 0;
		String a = "";
		u = Check(w);
		if (!co) {
			answer = w;
		} else {
			v = w.substring(t, w.length());
			// System.out.println(u + " " + v);
			for (int i = 0; i < u.length(); i++) {
				tmp = u.charAt(i);
				if (tmp == '(') {
					cnt1++;
				} else {
					cnt2++;
					if (cnt1 < cnt2)
						uF = true;
					break;
				}

			}
			if (uF) {
				a = "(";
				// System.out.println(u);
				a += Kakao02(v);
				// System.out.println(u);
				a += ")";
				for (int i = 0; i < u.length(); i++) {
					if (i == 0 || i == u.length() - 1)
						continue;
					tmp = u.charAt(i);
					if (tmp == '(')
						a += ")";
					else
						a += "(";
				}
				return a;
			} else if (!uF) {
				answer += u + Kakao02(v);
				return answer;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String s = ")()()()(";
		String s = "()))((()";
		System.out.println(Kakao02(s));
	}

	public static String Check(String w) {
		int cnt1 = 0;
		int cnt2 = 0;
		char tmp;
		String u = "";
		for (int i = 0; i < w.length(); i++) {
			tmp = w.charAt(i);
			if (tmp == '(') {
				cnt1++;
			} else {
				cnt2++;
				if (cnt1 < cnt2)
					co = true;
			}
			if (cnt1 == cnt2 && !flag) {
				u = w.substring(0, i + 1);
				t = i + 1;
				flag = true;
			}
		}
		return u;
	}

}
