package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2018_02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String canvas = br.readLine();
		String size[] = canvas.split(" ");
		String back = br.readLine();
		String color[] = back.split(" ");
		String s = color[2].replaceFirst("^0x", "");
		int co = Integer.parseInt(s, 16);
		String number = br.readLine();
		String frames[] = number.split(" ");
		String no = br.readLine();
		int n = Integer.parseInt(frames[3]);
		for (int i = 0; i < n; i++) {
			String fr = br.readLine();
			String an[] = fr.split(" ");
		}

		System.out.println(size[2]);
		System.out.println(size[4]);
		System.out.println(co);
		System.out.println(frames[3]);
	}

}
