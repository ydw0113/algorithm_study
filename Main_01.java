package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		String value = br.readLine();
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int max = 0;
		for (int i = 0; i <= n - m; i++) {
			String s = value.substring(i, i + m);
			max = Math.max(max, Integer.parseInt(s));
		}
		System.out.println(max);
		br.close();
	}

}
