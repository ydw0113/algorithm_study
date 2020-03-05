import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeQ1316 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i, n = Integer.parseInt(br.readLine());
		String s[] = new String[n];
		int count = 0;
		for (i = 0; i < n; i++) {
			s[i] = br.readLine();
		}
		while (n-- > 0) {
			Boolean a = true;
			for (i = 0; i < s[n].length()-1; i++) {
				if (s[n].charAt(i) != s[n].charAt(i + 1)) {
					for (int j = i + 2; j < s[n].length(); j++) {
						if (s[n].charAt(i) == s[n].charAt(j)) {
							a = false;
							break;
						}
					}
				}
				if(a==false)
					break;
			}
			if (a) 
				count++;
		}
		System.out.println(count);
	}

}
