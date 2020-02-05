import java.util.Arrays;
import java.util.Scanner;

public class griQ5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k[] = new int[n];
		int i,max = 0;
		for (i = 0; i < n; i++) {
			k[i] = sc.nextInt();
		}
		Arrays.sort(k);
		for(i=n-1;i>=0; i--) {
			if(max<k[i]*(n-i))
				max=k[i]*(n-i);
		}
		System.out.println(max);
		sc.close();
	}

}
