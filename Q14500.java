package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Q14500 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static BufferedReader br;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int max;
 
    public static void main(String[] args) throws Exception {
 
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N][M];
        visited = new boolean[N][M];
        max = 0;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
 
                DFS(i, j, 0, 0);
                Exception(i, j);
 
            }
        }
        System.out.println(max);
    }
    //상하좌우 가능한 모형들 (ㅗ 모양 제외)
    //'ㅗ' 모양은 DFS로 구현 불가
    public static void DFS(int x, int y, int depth, int sum) {
 
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
 
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }
            visited[nextX][nextY] = true;
            DFS(nextX, nextY, depth + 1, sum + arr[nextX][nextY]);
            visited[nextX][nextY] = false;
 
        }
 
    }
    //'ㅗ' 모양 구현
    //간단한 원리로는 + 모양에서 하나를 뺀다.
    public static void Exception(int x, int y) {
        int wing = 4;    // 가운데에서의 상하좌우 날개
        int min = Integer.MAX_VALUE;
        int sum = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
 
            //날개가 2개이상 없다면 ㅗ 모양이 아니다. 그러므로 함수를 종료한다.
            if (wing <= 2)
                return;
            //날개가 맵 바깥에 있다면 날개가 아니다.
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                wing--;
                continue;
            }
            min = Math.min(min, arr[nextX][nextY]);
            sum = sum + arr[nextX][nextY];
        }
        //날개가 4개일때 가장 작은 날개를 없애야 ㅗ,ㅏ,ㅓ,ㅜ 모양이 나온다.
        if (wing == 4) {
            sum = sum - min;
        }
        max = Math.max(max, sum);
    }
}
 