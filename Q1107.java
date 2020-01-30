package study;

import java.util.Scanner;
 
public class Q1107 {
    static boolean[] broken = new boolean[10]; // 버튼이 망가져 있으면 true, 아니면 false
    public static int canMove(int channel) { // 가능하면 수의 길이를 리턴, 불가능하면 0을 리턴
        int length = 0;
 
        if ( channel == 0 ) {
            return broken[0] ? 0 : 1;
        }
 
        while ( channel > 0 ) {
            if ( broken[channel % 10] ) {
                return 0;
            }
            length += 1;
            channel /= 10;
        }
        return length;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
 
        for (int i = 0; i < m; i++) {
            broken[scanner.nextInt()] = true; // 버튼이 망가져 있으면 true, 아니면 false
        }
 
        /** 100에서 n까지 숫자 버튼을 누르지 않고, +와 -만을 눌러서 이동하는 코드 */
        int answer = n - 100; // n >= 100
        if (answer < 0) {
            answer = -answer; // n < 100
        }
 
        /** 이동할 채널 c를 결정한 다음, 가능하면, 버튼을 총 몇번 눌러야 하는지 */
        for (int i = 0; i <= 1000000; i++) { // 숫자 버튼으로 이동하는 채널
        int c = i;
        int length = canMove(c); // 길이를 잰다.
        if (length > 0) {
            int press = c - n; // +나 -를 몇 번 눌러야 하는지 계산
            if (press < 0) {
                press = -press; // +를 누르는 경우
            }
            if (answer > length + press) {
                answer = length + press;
            }
        }
    }
        System.out.println(answer);
    }
 
 
 
}
