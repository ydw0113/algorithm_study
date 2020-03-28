package study;

public class Intern_05 {

	public static int solution(int[] stones, int k) {
		int answer = 0;
		int count = 0;
		boolean flag = false;
		for (int i = 0; i < stones.length; i++) {
			for (int j = 0; j < stones.length; j++) {
				System.out.print(stones[j]+" ");
				if (stones[j] == 0) {
					if (count > k) {
						flag = true;
						break;
					}
					count++;
				} else {
					stones[j]--;
				}
			}
			System.out.println();
			count = 0;
			answer++;
			if (flag)
				break;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stones[] = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		solution(stones, k);
	}

}
