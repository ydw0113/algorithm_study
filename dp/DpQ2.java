import java.util.Scanner;

public class DpQ2 {

	  public static void main(String[] args) {
		    int i,n,cash;
		    Scanner sc = new Scanner(System.in);
		    n = sc.nextInt();
		    int[] card = new int[n+1];
		    int[] dp = new int[n+1];
		    
		    for(i=1; i<=n; i++) card[i]= sc.nextInt();
		    
		    for(i=1; i<=n; i++) {
		    	for(int j=1; j<=i; j++) {
		    		if(dp[i]<card[j] +dp[i-j]) {
		    			dp[i] = card[j] + dp[i-j];
		    			System.out.println(dp[i]);
		    		}
		    	}
		    	
		    }
		    System.out.println(dp[n]);
		    sc.close();
		  }
}
