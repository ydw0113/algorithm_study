package study;

//발사한 신호는 신호를 보낸 탑보다 높은 탑에서만 수신합니다
//한 번 수신된 신호는 다른 탑으로 송신되지 않습니다.

public class P42588 {

	public static int[] solution(int[] heights) {
		int size = heights.length;
		int[] answer = new int[size];
		for (int i = size - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (heights[i] < heights[j]) {
					answer[i] = j+1;
					break;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int heights[] = { 3,9,9,3,5,7,2 };
		solution(heights);
	}

}
