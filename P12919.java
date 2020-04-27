package study;

public class P12919 {

	public static String solution(String[] seoul) {
		String answer = "";
		int a = 0;
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) {
				a = i;
				break;
			}
		}
		answer = "김서방은 " + a + "에 있다";
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seoul[] = { "Jane", "Kim" };
		solution(seoul);
	}

}
