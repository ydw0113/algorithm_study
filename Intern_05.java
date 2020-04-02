package study;

public class Intern_05 {

	public static int solution(int[] stones, int k) {
		int answer = 0;
		int max = 0;
		int size = stones.length;
		int min = 200000000;
		for (int i = 0; i < size; i++) {
			min = Math.min(min, stones[i]);
			max = Math.max(max, stones[i]);
		}
		int left = min;
		int right = max;
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 0;
			System.out.println(left + " " + right + " " + mid);
			for (int i = 0; i < size; i++) {
				if (count >= k)
					break;
				if (mid > stones[i]) {
					count++;
				} else
					count = 0;
				System.out.print(stones[i] + " ");
			}
			System.out.println();
			if (count < k) {
				answer = mid;
				left = mid + 1;
			} else if (count >= k) {
				right = mid - 1;
			}
		}

		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stones[] = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		solution(stones, k);
	}

}