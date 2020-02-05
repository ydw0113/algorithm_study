import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class griQ7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");
		String A = input[0];
		String B = input[1];
		int max_same = 0;
		for(int i=0; i<B.length()-A.length()+1; i++){
		   String temp_B = B.substring(i, i+A.length());
		   System.out.println(temp_B);
		   int same = 0;
		   for(int j=0; j<temp_B.length(); j++){
		       if(A.charAt(j) == temp_B.charAt(j))
		           ++same;
		  }
		   if(same > max_same)
		       max_same = same;
		}
		System.out.println(A.length() - max_same);
	}

}
