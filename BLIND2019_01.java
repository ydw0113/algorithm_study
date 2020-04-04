package study;

import java.util.ArrayList;

// 각 스테이지 통과 사용자 수 , 각 스테이지에 머물러 있는 사용자 수 구하기
// 각각의 실패율 구해서 스테이지 내림차순 정렬
public class BLIND2019_01 {
	public static int[] solution(int N, int[] stages) {
		int answer[] = new int[N];
		int arr[] = new int[N + 1];
		int an[] = new int[N + 1];
		ArrayList<Double> fail = new ArrayList<Double>();
		boolean visited[] = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = stages.length;
			an[i] = 0;
			for (int j = 0; j < stages.length; j++) {
				if (i > stages[j])
					arr[i]--;
				if (i == stages[j]) {
					an[i]++;
				}
			}
		}
		System.out.println(an[8]+" "+arr[8]);
		for (int i = 1; i <= N; i++) {
			if(an[i]==0 && arr[i]==0)
				fail.add((double)0);
			else
			fail.add((double) an[i] / (double) arr[i]);
		}
		int index = 1;
		int idx = 0;
		double max = 0;
		for (int i = 0; i < N; i++) {
			index = 0;
			max = -1;
			for (double a : fail) {
				if (visited[index]) {
					index++;
					continue;
				}
				if (max < a) {
					max = a;
					idx = index;
				}
				index++;
			}
			visited[idx] = true;
			answer[i] = idx + 1;
		}
		for (int i = 0; i < N; i++)
			System.out.print(answer[i] + " ");
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 8;
		int stages[] = { 2, 1, 2, 7, 2, 4, 3, 3 };
		solution(N, stages);
	}

}
