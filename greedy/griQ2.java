import java.util.Scanner;

public class griQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner a = new Scanner(System.in);
		int N=a.nextInt(); int K=a.nextInt();
		int A[]= new int [N];
		int i,count=0;
		for(i=0; i<N; i++)
			A[i]=a.nextInt();
		for(i=N-1; i>=0; i--) {
			count+=K/A[i];
			K%=A[i];
		}
		System.out.println(count);
		a.close();
	}

}
