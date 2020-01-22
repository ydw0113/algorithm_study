package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1946 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int tmp = 0;
		while (T > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int count = 1, max = 0;
			ArrayList<Person> q = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				q.add(new Person(a, b));
			}
			Collections.sort(q, new Comparator<Person>() {

				@Override
				public int compare(Person o1, Person o2) {
					// TODO Auto-generated method stub
					return o1.a < o2.a ? -1 : 1;
				}
			});

			int top = q.get(0).b;
			for (int i = 1; i < n; i++) {
				if (top > q.get(i).b) {
					count++;
					top = q.get(i).b;
				}
			}
			System.out.println(count);
			T--;
		}
	}

}

class Person {
	int a, b;

	public Person(int a, int b) {
		this.a = a;
		this.b = b;
	}
}
