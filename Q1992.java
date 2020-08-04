package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {
	public static int size;
	public static int[][] tree;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine());
		tree = new int[size][size];
		sb = new StringBuilder();

		for (int i = 0; i < size; i++) {
			String str = br.readLine();
			for (int j = 0; j < size; j++) {
				tree[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}

		Quad(0, 0, size);
		System.out.println(sb.toString());
	}

	public static boolean isAble(int row, int col, int size) {
		int t = tree[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (t != tree[i][j])
					return false;
			}
		}
		return true;
	}

	public static void Quad(int row, int col, int size) {
		if (isAble(row, col, size)) {
			sb.append(tree[row][col]);
		} else {
			sb.append("(");
			int newSize = size / 2;

			Quad(row, col, newSize);
			Quad(row, col + newSize, newSize);
			Quad(row + newSize, col, newSize);
			Quad(row + newSize, col + newSize, newSize);

			sb.append(")");
		}
	}
}
