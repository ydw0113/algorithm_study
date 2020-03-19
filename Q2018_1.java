package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2018_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder s = new StringBuilder();

		while (T > 0) {
			LinkedList<cur> list = new LinkedList<cur>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				list.add(new cur(x, y, name));
			}
			double brMin = 1000000;
			double coMin = 1000000;
			double dis;
			LinkedList<Double> coList = new LinkedList<>();
			LinkedList<Double> brList = new LinkedList<>();
			for (cur i : list) {
				if (i.name.equals("Brown")) {
					dis = Math.sqrt(Math.pow(Math.abs(0 - i.x), 2) + Math.pow(Math.abs(0 - i.y), 2));
					brMin = Math.min(dis, brMin);
					brList.add(dis);
				} else {
					dis = Math.sqrt(Math.pow(Math.abs(0 - i.x), 2) + Math.pow(Math.abs(0 - i.y), 2));
					coMin = Math.min(dis, coMin);
					coList.add(dis);
				}
			}
			int count = 0;
			if (brMin < coMin) {
				for (double i : brList) {
					if (coMin > i)
						count++;
				}
				s.append("Brown " + count + "\n");
			} else {
				for (double i : coList) {
					if (brMin > i)
						count++;
				}
				s.append("Cony " + count + "\n");
			}
			T--;
		}
		System.out.print(s);
	}

}

class cur {
	int x;
	int y;
	String name;

	public cur(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
}