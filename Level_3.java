package study;

public class Level_3 {
    static int answer =-1;
	public static int Level_3(int N, int number) {
		
		cal(N, number, 0,0);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void cal(int N, int number, int cnt, int prev) {
        int temp_N = N;
        if (cnt > 8) {
            answer = -1;
            return;
        }
		
        if (number == prev ) {
            if (answer == -1 || answer > cnt)
                answer = cnt;
            return;
        }
        for (int i = 0; i < 8-cnt; i++) {
        	cal(N, number, cnt+i+1, prev-temp_N);
        	cal(N, number, cnt+i+1, prev+temp_N);
        	cal(N, number, cnt+i+1, prev*temp_N);
        	cal(N, number, cnt+i+1, prev/temp_N);
            
            temp_N =  increaseNumber(temp_N, N);
        }
        
	}

    static int increaseNumber(int value, int N) {
        return value * 10 + N;
    }

}
