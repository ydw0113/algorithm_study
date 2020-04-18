package study;

// 물건이 놓인 칸 -1 , 쌓여있는 먼지의 양은 0이상의 정수
// 0 = 북   1 = 동    2 = 서    3 = 남 
public class challenge_02 {

	public static int solution(int[][] office, int r, int c, String[] move) {
		int answer = 0;
		int d = 0;
		answer += office[r][c];
		office[r][c] = 0;
		int nx = c, ny = r;
		for (int i = 0; i < move.length; i++) {
			if (move[i].equals("go")) {
				if (d == 0) {
					ny = r - 1;
				} else if (d == 1) {
					nx = c + 1;
				} else if (d == 2) {
					nx = c - 1;
				} else if (d == 3) {
					ny = r + 1;
				}
			} else if (move[i].equals("right")) {
				if (d == 0) {
					d = 1;
				} else if (d == 1) {
					d = 3;
				} else if (d == 2) {
					d = 0;
				} else if (d == 3) {
					d = 2;
				}
			} else if (move[i].equals("left")) {
				if (d == 0) {
					d = 2;
				} else if (d == 1) {
					d = 0;
				} else if (d == 2) {
					d = 3;
				} else if (d == 3) {
					d = 1;
				}
			}

			if (nx < 0 || ny < 0 || nx >= office.length || ny >= office.length) {
				nx = c;
				ny = r;
				continue;
			}
//			System.out.println(ny + " " + nx + " " + move[i] + "  " + d + " " + office[ny][nx]);
			if (office[ny][nx] != -1) {
				answer += office[ny][nx];
				office[ny][nx] = 0;
				r = ny;
				c = nx;
				 System.out.println(ny+" "+nx);
			} else {
				ny = r;
				nx = c;
			}

		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] office = { { 5, -1, 4 }, { 6, 3, -1 }, { 2, -1, 1 } };
		int r = 1;
		int c = 0;
		String[] move = { "go", "go", "right", "go", "right", "go", "left", "go" };
		solution(office, r, c, move);
	}

}
