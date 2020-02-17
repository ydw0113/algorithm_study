package study;

import java.util.Scanner;

public class Q10844 {

	public static void main(String[] args) {
        final int mod = 1000000000;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long [][] dp = new long[n+1][10];
        
        for(int i=1; i<10; i++)
            dp[1][i] = 1;
        
        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) {
                if(j == 0)
                    dp[i][j] = dp[i-1][j+1];
                else if(j == 9)
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                dp[i][j] %= mod;
            }
        }
        long answer = 0;
        for(int i=0; i<10; i++)
            answer += dp[n][i];
        
        System.out.println(answer%mod);
    }
 
 

}
