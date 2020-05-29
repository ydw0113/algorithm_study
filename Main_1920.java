package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1920 {
	static int arr[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		HashMap map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int k = Integer.parseInt(st.nextToken());
			if (map.containsKey(k)) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
	}

}
