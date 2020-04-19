package study;

public class challenge_01 {

	public static int solution(String p, String s) {
		int answer = 0;
		for (int i = 0; i < p.length(); i++) {
			int cur = p.charAt(i) - '0';
			int t = s.charAt(i) - '0';

			if (Math.abs(cur - t) > 5) {
				answer += 10 - Math.abs(cur - t);
			} else {
				answer += Math.abs(cur - t);
			}
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "82195";
		String s = "64723";
		solution(p, s);
	}

}
