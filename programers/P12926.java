package study;

public class P12926 {

	public static String solution(String s, int n) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			int tmp = s.charAt(i);
			if (tmp == 126) {
				answer += " ";
				continue;
			} else if (tmp >= 65 && tmp <= 90) {
				tmp += n;
				if (tmp > 90)
					tmp -= 26;
			} else if (tmp >=97  && tmp <=122){
				tmp += n;
				if (tmp > 122)
					tmp -= 26;
			}
			answer += (char) tmp;
			System.out.println(answer);
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("a B z", 4);
	}

}
