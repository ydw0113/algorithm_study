package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9252 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String s2 = br.readLine();
		int dp[][] = new int[s.length() + 1][s2.length() + 1];
		String lcs[][] = new String[s.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s.length(); i++)
			Arrays.fill(lcs[i], "");

		for (int i = 1; i <= s.length(); i++) {
			char c1 = s.charAt(i - 1);

			for (int j = 1; j <= s2.length(); j++) {

				char c2 = s2.charAt(j - 1);

				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					lcs[i][j] += lcs[i - 1][j - 1] + c1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					if (lcs[i - 1][j].length() > lcs[i][j - 1].length())
						lcs[i][j] = lcs[i - 1][j];
					else
						lcs[i][j] = lcs[i][j - 1];
				}

			}

		}
		System.out.println(dp[s.length()][s2.length()]);
		System.out.println(lcs[s.length()][s2.length()]);

	}

}
