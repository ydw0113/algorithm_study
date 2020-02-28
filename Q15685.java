package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15685 {
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
	}
}

class dra {
	int x, y, d, g;

	public dra(int x, int y, int d, int g) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.g = g;
	}
}