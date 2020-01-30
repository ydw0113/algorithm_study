package study;

public class Solution {
	public static int Solution(String[] A) {
		String B[] = A;
		int LCS[][] = new int[101][101];
		int ans = 0;
		String t = "";
		Boolean flag = false;
		int count = 0;
		int max = 0;
		String tmp[] = new String[101];
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if (A[i - 1] != B[j - 1]) {
					// System.out.println(A[i -1]+" "+B[j-1]);
					String tmp2[] = new String[101];

					tmp = A[i - 1].split("");
					tmp2 = B[j - 1].split("");
					for (int a = 0; a < tmp.length; a++) {
						for (int b = 0; b < tmp2.length; b++) {
							if (tmp[a].equals(tmp2[b])) {
								flag = false;
								break;
							}
							// System.out.println(tmp[a] + " " + tmp2[b]);
						}
					}
					if (flag) {
						for (int z = 0; z < tmp2.length; z++) {
							tmp[z] = tmp2[z];
						}
						count += tmp.length + tmp2.length;
					}
					if (count > max)
						max = count;
					// System.out.println(count+" "+flag);
					flag = true;
				}
				count = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] A = { "abc", "yyy", "def", "csv" };
		System.out.println(Solution(A));
	}

}