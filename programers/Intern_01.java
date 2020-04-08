package study;

import java.util.Stack;

public class Intern_01 {
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		int arr[] = new int[moves.length];
		int index = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[j][moves[i] - 1] == 0)
					continue;
				else {
					stack.add(board[j][moves[i] - 1]);
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
		}

		for (int i = 0; i < stack.size() - 1; i++) {
			if (stack.get(i) == stack.get(i + 1)) {
				stack.remove(i);
				stack.remove(i);
				i = -1;
				answer += 2;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int board[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int moves[] = { 1, 5, 3, 5, 1, 2, 1, 4 };
		solution(board, moves);
	}

}
