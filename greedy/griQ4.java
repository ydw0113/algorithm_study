import java.util.Scanner;

public class griQ4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); int K=1000;
		int a[] = {500,100,50,10,5,1};
		int count=0;
		K-=n;
		for(int i=0; i<a.length; i++) {
			count+=K/a[i];
			K%=a[i];
		}
		System.out.println(count);
		sc.close();
	}

}
