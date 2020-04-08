package study;

public class Solution_02 {
	static int arr[][] = new int[11][11];
	static boolean visited[][][] = new boolean[11][11][4];
	static int count = 0;

	public int solution(String dirs) {
		int answer = 0;
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arr[5][5] = 0;
		bfs("ULURRDLLU", 5, 5);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
		System.out.println(count);
	}

	public static void bfs(String dirs, int x, int y) {
		arr[y][x] = 0;
		for (int i = 0; i < dirs.length(); i++) {
			int nx = x;
			int ny = y;
			int a = 0;
			int t = 0;
			if (dirs.charAt(i) == 'L') {
				a = 0;
				x--;
			} else if (dirs.charAt(i) == 'U') {
				a = 1;
				y--;
			} else if (dirs.charAt(i) == 'R') {
				a = 2;
				x++;
			} else if (dirs.charAt(i) == 'D') {
				a = 3;
				y++;
			}
			if (a == 0) {
				t = 2;
			} else if (a == 1) {
				t = 3;
			} else if (a == 2) {
				t = 0;
			} else if (a == 3) {
				t = 1;
			}
			visited[ny][nx][t] = true;

			if (x < 0 || y < 0 || x > 10 || y > 10) {
				x = nx;
				y = ny;
				continue;
			}
			if (visited[y][x][a])
				continue;

			count++;
			arr[y][x] = arr[ny][nx] + 1;
			visited[y][x][a] = true;
		}
	}

}

class doot {
	int x;
	int y;

	public doot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}