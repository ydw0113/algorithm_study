import java.util.Scanner;

public class Dp1149 {

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[][] w = new int[n][3];
    int[][] dp = new int[n][3];
    // dp : n번째 집을 각각 빨강, 초록, 파랑으로 칠했을 때 n번째까지의 최소합을 담아놓는 배열

    for(int i = 0; i < n; i++){
      for(int j = 0; j < 3; j++){
        w[i][j] = scan.nextInt();
      }
    }
    // 첫번째 집까지의 칠할 때 색깔 별 최소 비용은 첫번째 집의 색칠 비용 그 자체 즉 기본값이 된다.
    // 0: 빨강, 1: 초록, 2: 파랑 순
    dp[0][0] = w[0][0];
    dp[0][1] = w[0][1];
    dp[0][2] = w[0][2];

    for(int i = 1; i < n; i++){
      dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + w[i][0];
      dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + w[i][1];
      dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + w[i][2];
    }

    int min = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    System.out.println(min);
  }
}