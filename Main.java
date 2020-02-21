package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double h = Integer.parseInt(st.nextToken());
		double u = Integer.parseInt(st.nextToken());
		double d = Integer.parseInt(st.nextToken());
		double f = Integer.parseInt(st.nextToken());
		double n = 0;
		int day = 1;
		String answer = "";
		f = 0.01 * (100 - f);
		boolean flag = false;
		while (true) {
			if (day == 1) {
				n = n + u;
			} else
				n = n + u * f;
			if (n > h) {
				answer = "Success " + Integer.toString(day);
				break;
			} else if (n < 0) {
				answer = "Failure " + Integer.toString(day);
				break;
			}
			n -= d;
			day++;
		}
		System.out.println(answer);
	}
}