package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q2580 {
	static int n = 9, count = 0, result = 0;;
	static boolean visited[];
	static int arr[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[n][n];
		visited = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {

			for (int i = count; i < count + 3; i++) {
				for (int j = result; j < result + 3; j++) {
					if (arr[i][j] == 0) {
//						System.out.println(i+"   "+j);
						colCheck(i);
						rowCheck(j);
						for (int a = 1; a <= n; a++) {
							if (!visited[a])
								arr[i][j] = a;
							visited[a] = false;
						}
					}else
						visited[arr[i][j]] = true;
				}
			}
			if (result == 6) {
				count += 3;
				result = 0;
				for (int a = 1; a <= n; a++) {
					visited[a] = false;
				}
			} else {
				result += 3;
				for (int a = 1; a <= n; a++) {
					visited[a] = false;
				}	
			}
			if (count == 9)
				break;
		}
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
	}

	public static void colCheck(int y) {
		for (int i = 0; i < n; i++) {
			visited[arr[y][i]] = true;
		}

	}

	public static void rowCheck(int x) {
		for (int i = 0; i < n; i++) {
			visited[arr[i][x]] = true;
		}

	}

}
