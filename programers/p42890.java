package study;

import java.util.LinkedList;

public class p42890 {

	public static int solution(String[][] relation) {
		int answer = 0;
		int size = relation[0].length;
		int count = 0;
		boolean flag = true;
		LinkedList<Integer> li = new LinkedList<>();
		for (int i = 1; i < (1 << (size)); i++) {
			flag = true;
			LinkedList<Integer> list = new LinkedList<>();
			for (int j = 0; j < size; j++) {
				if ((i & (1 << j)) > 0) {
					list.add(j);
				}
			}
			if (solve(list, relation)) {
				for (int a : li) {
					if ((a & i) == a) {
						flag = false;
						break;
					}
				}
				if (flag) {
					li.add(i);
					count++;
				}
			}
		}
		System.out.println(count);
		return answer;
	}

	public static boolean solve(LinkedList<Integer> list, String[][] relation) {
		boolean flag = true;
		for (int i = 0; i < relation.length; i++) {
			String tmp = "";
			for (int a : list) {
				tmp += relation[i][a];
			}

			for (int j = i + 1; j < relation.length; j++) {
				String tmp2 = "";
				for (int a : list) {
					tmp2 += relation[j][a];
				}

				if (tmp2.equals(tmp)) {
					flag = false;
				}
			}

		}
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String relation[][] = { { "a", "1", "4" }, { "2", "1", "5" }, { "a", "2", "4" } };
		solution(relation);
	}

}
