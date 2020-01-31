import java.math.BigInteger;
import java.util.Scanner;
public class DpQ1010 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		for (int i = 0; i < testCase; i++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			System.out.println(factorial(m).divide(factorial(n)).divide(factorial(m - n)));
		}
		scanner.close();
	}

	public static BigInteger factorial(int num) {
		BigInteger fac = BigInteger.ONE;
		for (int i = 2; i <= num; i++) {
			fac = fac.multiply(BigInteger.valueOf(i));
		}
		return fac;
	}

}