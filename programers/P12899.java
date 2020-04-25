package study;

public class P12899 {

	public static String solution(int n) {
		String answer = "";
		int count = 0;
		while (n > 0) {
			count = n % 3;
			n /= 3;
			if (count == 0) {
				n--;
				count = 4;
			}
			answer = count+answer;
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(2);
	}
}
