package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 택배 문제
// 그리디 알고리즘
public class Q8980 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.valueOf(st.nextToken());
		int truck = Integer.valueOf(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int m = Integer.valueOf(st.nextToken());

		int[] boxs = new int[n + 1]; // 인덱스 : 1 ~ n까지. 해당 index 마을에 도착했을 때의 트럭에 담은 박스 개수
		ArrayList<Town> towns = new ArrayList<Town>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int box = Integer.valueOf(st.nextToken());
			towns.add(new Town(from, to, box));
		}

		Collections.sort(towns); // 받는 마을 오름차순 정렬

		int boxCount = 0;
		for (Town town : towns) {
			int start = town.start;
			int end = town.end;
			int box = town.box;

			int max = 0;
			boolean isLoad = true;
			for (int i = start; i < end; i++) {
				if (boxs[i] >= truck) {
					isLoad = false;
					break;
				}
				max = Math.max(max, boxs[i]);
			}

			if (isLoad) {
				int unloads = truck - max;
				if (unloads > box) {
					unloads = box;
				}
				boxCount += unloads;
				for (int i = start; i < end; i++) {
					boxs[i] += unloads;
				}
			}
		}
		System.out.println(boxCount);
	}
}

class Town implements Comparable<Town> {
	int start;
	int end;
	int box;

	Town(int start, int end, int box) {
		this.start = start;
		this.end = end;
		this.box = box;
	}

	// 오름차순 정렬을 위한 Comparable 클래스 함수 사용
	@Override
	public int compareTo(Town town) {
		if (this.end < town.end) {
			return -1;
		} else if (this.end == town.end) {
			return 0;
		} else {
			return 1;
		}
	}
}