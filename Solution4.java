package study;

import java.util.Arrays;
import java.util.Collections;

public class Solution4 {
	static public int Solution4(int[] citations) {
		Integer[] cArr = new Integer[citations.length];
		for (int i = 0; i < citations.length; i++) {
			cArr[i] = citations[i];
		}
		Arrays.sort(cArr, Collections.reverseOrder());
		for (int i = 0; i < citations.length; i++) {
			if (cArr[i] < i + 1) {
				return i;
			}
		}
		return citations.length;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = { 3, 0, 6, 1, 5 };
		Solution4(citations);
	}

}
