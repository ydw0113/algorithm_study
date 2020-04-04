package study;

import java.util.ArrayList;
import java.util.Scanner;

// 연속 감소 ,증가,  같은 값 반복
public class L5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		boolean check = false;
		int index = 0;
		for (int i = 1; i < n; i++) {
			if (list.get(index) == arr[i])
				continue;
			if (!check) {
				if (list.get(index) > arr[i])
					continue;
				else {
					list.add(arr[i]);
					index++;
					check=true;
				}
			} else {
				if (list.get(index) < arr[i])
					continue;
				else {
					list.add(arr[i]);
					index++;
					check=false;
				}
			}
		}
		System.out.println(list.size());
		sc.close();
	}

}
