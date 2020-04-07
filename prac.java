package study;

import java.util.ArrayList;
import java.util.Collections;

public class prac {
	public static String[] solution(String[] directory, String[] command) {
		ArrayList<String> list = new ArrayList<>();

		for (String s : directory) {
			list.add(s);
		}
		Collections.sort(list);

		for (String s : command) {
			String tmp[] = s.split(" ");
			if (tmp[0].equals("mkdir")) {
				list.add(tmp[1]);
			} else if (tmp[0].equals("cp")) {
				int size = list.size();
				for (int i = 0; i < size; i++) {
					if (list.get(i).startsWith(tmp[1])) {
						if (tmp[2].equals("/"))
							list.add(tmp[1]);
						else
							list.add(tmp[2] + list.get(i));
					}
				}
			} else if (tmp[0].equals("rm")) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).startsWith(tmp[1])) {
						list.remove(i);
						i--;
					}
				}
			}
		}
		Collections.sort(list);
		String[] answer = new String[list.size()];
		for (String s : list)
			System.out.println(s);
		for (int i = 0; i < list.size(); i++)
			answer[i] = list.get(i);
		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] directory = { "/" };
		String[] command = { "mkdir /a", "mkdir /a/b", "mkdir /a/b/c", "cp /a/b /", "rm /a/b/c" };
		solution(directory, command);
	}

}
