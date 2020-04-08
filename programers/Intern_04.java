package study;

import java.util.ArrayList;
import java.util.HashMap;

public class Intern_04 {

	public static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		HashMap<Long, Long> hash = new HashMap<>();
//		for (long i = 1; i <= k; i++)
//			hash.put(i, i);
		ArrayList<Long> a = new ArrayList<>();
		for (int i = 0; i < room_number.length; i++) {
			long tmp = room_number[i];
			if(hash.get(tmp)==null) {
				answer[i]=tmp;
				hash.put(tmp,tmp+1);
				continue;
			}
			while (hash.get(tmp) != tmp) {
				a.add(tmp);
				tmp = hash.get(tmp);
				if(hash.get(tmp)==null) {
					break;
				}
			}
			answer[i] = tmp;
			hash.put(tmp, tmp + 1);
			for (long j : a) {
				hash.put(j, tmp + 1);
			}
			a.clear();
		}
		for (long i = 1; i <= k; i++) 
			System.out.print(i+" ");
		System.out.println();
		for (long i = 1; i <= k; i++) {
			System.out.print(hash.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 12;
		long[] room_number = { 1, 3, 4, 1, 3, 5, 4, 1, 3, 1, 4, 3 };
		solution(k, room_number);
	}

}
