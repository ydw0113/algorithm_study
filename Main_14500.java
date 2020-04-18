package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14500 {
	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int max;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        arr = new int[n][m];
        visited = new boolean[n][m];
        max = 0;
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
	}

}
