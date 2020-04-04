package study;

// n 편 중 h번 이상 인용된 논문이 h편 이상, 나머지느가 h 편 이하 인용 된 것 찾기
// 그 값들 중 최대값 구하기

public class Q42747 {
	public static int solution(int[] citations) {
		int answer = 0;
		int over = 0;
		int under = 0;
		for (int i = 0; i <=citations.length; i++) {
			over = 0;
			under = 0;
			for (int j = 0; j < citations.length; j++) {
				if (i <= citations[j])
					over++;
				if (i >= citations[j])
					under++;
			}
			if (i <= over && i >= under)
				answer = Math.max(answer, i);
		}
		System.out.println(answer);

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = { 3, 0, 6, 1, 5 };
		solution(citations);
	}

}
