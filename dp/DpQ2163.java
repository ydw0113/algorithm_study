import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DpQ2163 {
	static int[][] ARR = new int[301][301];
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=M; j++) {
				int num = Integer.parseInt(st.nextToken());;
				ARR[i][j] = num;
			}
		}
		
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int result = 0;
			
			for(int a = i; a <= x; a++) {
				for(int b = j; b <= y; b++) {
					result += ARR[a][b];
				}
			}

			System.out.println(result);
		}
	}
}