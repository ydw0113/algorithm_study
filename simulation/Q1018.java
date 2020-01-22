package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String tmp;
		String[][] arr = new String[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = st.nextToken("");
			arr[i] = tmp.split("");
		}
		int min = 10000;
		int tmpMin = 10000;
		int count = 0;
		int count2 = 0;
		for (int a = 0; a <= n - 8; a++) {
			for (int b = 0; b <= m - 8; b++) {
				count = 0;
				count2 = 0;
				for (int i = 0; i < 8; i++) {

					if ((i + a) < arr.length) {
						if ((i + a) % 2 != 0) {

							for (int j = 0; j < 8; j++) {
								if (j % 2 == 0) {
									if (!arr[i + a][j + b].equals("W")) {
										count2++;
									}
								} else if (j % 2 != 0) {
									if (!arr[i + a][j + b].equals("B")) {
										count2++;
									}
								}
							}
						} else {
							for (int j = 0; j < 8; j++) {
								if (j % 2 != 0) {
									if (!arr[i + a][j + b].equals("W")) {
										count2++;
									}

								} else if (j % 2 == 0) {
									if (!arr[i + a][j + b].equals("B")) {
										count2++;
									}
								}
							}
						}

						if ((i + a) < arr.length) {
							if ((i + a) % 2 == 0) {

								for (int j = 0; j < 8; j++) {
									if (j % 2 == 0) {
										if (!arr[i + a][j + b].equals("W")) {
											count++;
										}
									} else if (j % 2 != 0) {
										if (!arr[i + a][j + b].equals("B")) {
											count++;
										}
									}
								}
							} else {
								for (int j = 0; j < 8; j++) {
									if (j % 2 != 0) {
										if (!arr[i + a][j + b].equals("W")) {
											count++;
										}

									} else if (j % 2 == 0) {
										if (!arr[i + a][j + b].equals("B")) {
											count++;
										}
									}
								}
							}
								tmpMin = count < count2 ? count : count2;
						}

					}
				}
				if (min > tmpMin) {
					min = tmpMin;
				}
			}
		}
		System.out.println(min);
	}
}
