import java.util.Scanner;

public class restaurant {
	
	
	public static int pe(int 측정시간) {
		
		int n;
		n=측정시간/10;	
		
		return n*7;
	}

	public static int customer (int 측정시간, int 요리사, int 청소스탭,int 테이블,int 손님가능 ) {
		int 요리시간=0;
		int 청소시간=0;
		int 식사시간=0;
		int 손님=0;
		요리시간=(테이블/요리사)*4;
		청소시간=(테이블/청소스탭)*3;
		손님=(측정시간-요리시간-청소시간)/11;
		if(손님 <= 손님가능)
			return 손님;
		System.out.println(요리시간);
		System.out.println(청소시간);
		System.out.println(손님);
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tm = new Scanner(System.in);
	    System.out.println("측정시간을 입력하세요(시간만 정수로)");
	    int 측정시간 = tm.nextInt();
		Scanner co = new Scanner(System.in);
	    System.out.println("요리사 수를 입력하세요(1명 이상 100명 이하로 입력)");
	    int 요리사 = co.nextInt();
		Scanner st = new Scanner(System.in);
	    System.out.println("청소 스탬 수를 입력하세요(1명 이상 200명 이하로 입력)");
	    int 청소스탭 = st.nextInt();
		Scanner ta = new Scanner(System.in);
	    System.out.println("테이블 수를 입력하세요(1개 이상 10,000개 이하로 입력)");
	    int 테이블 = ta.nextInt();
	    
	    int 손님가능=pe(측정시간);
	    
	    System.out.println(customer(측정시간, 요리사 ,청소스탭, 테이블,손님가능));
	    
	}

}
