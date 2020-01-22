package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Q1931 {
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //끝나는 시간을 기준으로 정렬을 하고 만약 같을 경우에는 시작시간을 기준으로 한다.
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                if(arg0[1] == arg1[1]) {
                    return arg0[0] - arg1[0];
                } else {
                    return arg0[1] - arg1[1];
                }
            }
        });    
        
        int end = -1;
        int count = 0;
        
        //끝나는 시간을 계속 수정해주며 회의를 진행한다.
        for(int i=0; i<N; i++) {
            if(time[i][0] >= end ) {
                end = time[i][1];
                count++;
            }
        }
        
        System.out.println(count);
    }
 
}
