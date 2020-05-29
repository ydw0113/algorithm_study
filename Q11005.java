package study;

import java.util.Scanner;

public class Q11005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  =new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		String s="";
		while(n>0) {
			int tmp = n%b;
			if(tmp>=10) {
				s+= (char)(55+tmp);
			}else {
				s+=(char)(tmp+'0');
			}
			n=n/b;
		}
		for(int i= s.length()-1; i>=0; i--)
			System.out.print(s.charAt(i));
		
		sc.close();
	}

}
