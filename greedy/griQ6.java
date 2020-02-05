import java.util.*;

public class griQ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int team = 0;
        if (n + m > k) {
            team = n / 2 < m ? n / 2 : m;
            k -= (n + m) - team * 3; // rest 제외
            if (k > 0) team -= (k + 2) / 3;
        }
        System.out.println(team);
    }
}