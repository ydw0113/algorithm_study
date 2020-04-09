package study;

public class level4_01 {
	public static int solution(int[] food_times, long k) {
		int answer = 0;
		int min = 1000000000;
		int arr[] = new int[food_times.length];
		for (int i = 0; i < food_times.length; i++) {
			arr[i] = food_times[i];
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] food_times = { 3, 1, 2 };
		int k = 5;
		solution(food_times, k);
	}

}
