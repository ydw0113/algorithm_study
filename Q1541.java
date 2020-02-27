package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\-");

		int min = 0;
		for (int i = 0; i < input.length; i++) {
			String s[] = input[i].split("\\+");
			int sum = 0;
			for (int j = 0; j < s.length; j++) {
				sum += Integer.parseInt(s[j]);
			}
			if (i == 0)
				sum *= -1;
			min -= sum;

		}
		System.out.println(min);
	}

}
