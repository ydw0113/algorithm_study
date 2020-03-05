import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeQ1100 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		String n[] = new String[8];
		int count = 0;
		for (i = 0; i < 8; i++) {
			n[i] = br.readLine();
		}
		for (i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 1) {
					if (n[i].charAt(j) == 'F' && j % 2 == 1) {
						count++;
					}
				} else {
					if (n[i].charAt(j) == 'F' && j % 2 == 0) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

}
