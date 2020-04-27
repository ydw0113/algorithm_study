package study;

public class P12985 {
	
	
    public int solution(int n, int a, int b)
    {
        int answer = 3;

        int count = 0;
        while(a != b) {
        	a = a/2 + a%2;
        	b = b/2 + b%2;
        	count++;
        }
        System.out.println(count);
        return answer;
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
