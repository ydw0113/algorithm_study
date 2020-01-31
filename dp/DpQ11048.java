import java.util.Scanner;

public class DpQ11048 {
    public static int n;
    public static int m;
    public static int[][] inputAry;
    public static int[][] candyCntMap;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        inputAry = new int[n+1][m+1];
        candyCntMap = new int[n+1][m+1];
		
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                inputAry[i][j] = sc.nextInt();
            }
        }
		
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                candyCntMap[i][j] += Math.max(candyCntMap[i-1][j], candyCntMap[i][j-1]) + inputAry[i][j];
            }
        }	
        System.out.println(candyCntMap[n][m]);
    }
}