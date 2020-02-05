import java.util.Arrays;
import java.util.Scanner;

public class griQ1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner a = new Scanner(System.in);
		int N =a.nextInt();
		int person[]=new int[N];
		for(int i=0; i<N; i++) {
			person[i]=a.nextInt();
		}
		Arrays.sort(person);
		int sum=0;
		int result = 0;
		for(int i=0; i<N; ++i) {
			sum=person[i]+sum;
			result=sum+result;
		}
		System.out.println(result);
		a.close();
	}
}
