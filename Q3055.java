package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3055 {
	static int r, c;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static boolean visited[][];
	static int arr[][];
	static Queue<Integer
	> water = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			String tmp[] = s.split("");
			for (String str : tmp) {
				if (str.equals("D")) {

				} else if (str.equals("*")) {

				} else {

				}
			}
		}

	}

}
