package study;

import java.util.ArrayList;

//1번 규칙 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣는다  ex ) HELLO -> HaEaLaLaO
//2번 규칙 특정 단어를 선택하여 단어 앞뒤에 같은 기호를 넣는다. ex) WORLD -> bWORLDb
//위의 두 가지 규칙은 한 단어에 모두 적용될 수 있지만 같은 규칙은 두 번 적용될 수 없다.
//한 번 쓰인 소문자(특수기호)는 다시 쓰일 수 없다.
//마지막으로 원래 문구에 있던 공백을 제거한다.
public class P1830 {
	public static String solution(String sentence) {
		String answer = "";
		ArrayList<Character> list = new ArrayList<>();
		int index = 0;
		int count = 0;
		int rCnt = 0;
		boolean rule1 = false;
		boolean rule2 = false;
		boolean rule3 = false;
		ArrayList<Character> flag = new ArrayList<>();
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) >= 97 && sentence.charAt(i) <= 122) {
				if (list.contains(sentence.charAt(i))) {
					if (flag.contains(sentence.charAt(i))) {
						answer = "invalid";
						break;
					}
					// 1번 규칙
					if (rule3 && rCnt == 1) {
						answer = "invalid";
						break;
					}
					if (count == 1) {
						if (rCnt >= 1 && !rule1) {
							rule1 = true;
							rule3 = false;
						}
						rCnt++;
					} else if (count != 1 && rule1) {
						answer = "invalid";
						break;
					}

					// 2번 규칙
					if (count > 1 && !rule2) {
						rule2 = true;

					} else if (rule2) {
						rCnt++;
						if (rCnt > 2) {
							answer = "invalid";
							break;
						}
					}
					count = 0;
				} else {
					if (!list.isEmpty()) {
						if (answer.charAt(answer.length() - 2) != ' ') {
							answer += " ";
							if (rule1)
								rule3 = true;
						}
						flag.add(list.get(index));
						index++;
					}
					list.add(sentence.charAt(i));
					rule1 = false;
					rule2 = false;
					count = 0;
					rCnt = 0;
				}
			} else {
				count++;
				if (rule1 && i != sentence.length() - 1) {
					if (count > 1)
						answer += " ";
				}
				answer += sentence.charAt(i);
			}
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("HaEaLaLaOaWORLDa");
	}

}
