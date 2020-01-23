import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DpQ11727 {
 public static void main(String[] args) throws Exception{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int n = Integer.parseInt(br.readLine());
  int tile[] = new int[1001];
  
  tile[1] = 1;
  tile[2] = 3;
  for(int i=3; i<=n; i++){
   tile[i] = (tile[i-1] + tile[i-2]*2) % 10007;
  }
  
  System.out.println(tile[n]);
 }
}