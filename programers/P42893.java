package study;

import java.util.ArrayList;
import java.util.HashMap;

// 기본점수, 외부 링크 수, 링크점수 ,매칭점수
// 기본점수 = 검색어 횟수  (대소문자 무시)
// 외부 링크 수 = 다른 외부 페이지로 연결된 링크 개수
// 링크 점수 = 링크가 걸린 다른 웹페이지의 기본점수 / 외부 링크 수
// 매칭점수 = 기본점수 + 링크점수
// 가장 높은 웹페이지의 index 값을 구하라  만약 여러 개라면 그중 번호가 가장 작은 것

// 검색어는 단어 단위로 비교, 완전히 일치하는 경우만
// aba  = aba@aba aba  = 3

public class P42893 {

	public static int solution(String word, String[] pages) {
		int answer = 0;
		int count = 0;
		int cnt = 0;
		int outlink[] = new int[pages.length];
		int arr[] = new int[pages.length];
		double link[] = new double[pages.length];
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < pages.length; i++) {
			String s[] = pages[i].split(" ");
			count = 0;
			cnt = 0;
			word = word.toUpperCase();
			String c="";
            for (String t : s) {
				if (t.startsWith("content=\"https://")) {
					String tmp[] = t.split("=");
					String a[] = tmp[1].split("/>");
					map.put(a[0], i);
				}
				if (t.startsWith("href=\"https://") && c.contains("<a")) {
					count++;
				}
                c =t;

			}
			s = pages[i].split("\\W");
			for (String t : s) {
				String tmp[] = t.split("\\d");
				for (String a : tmp) {
					String up = a.toUpperCase();
					if (up.startsWith(word) && up.length() == word.length()) {
						cnt++;
					}

				}
			}
			arr[i] = cnt;
			outlink[i] = count;
		}

		for (int i = 0; i < pages.length; i++) {
			String s[] = pages[i].split(" ");
			for (String t : s) {
				if (t.startsWith("href=\"https://")) {
					String tmp[] = t.split("=");
					String a[] = tmp[1].split(">");
                    
					if (!map.containsKey(a[0]))
						continue;
					int home = map.get(a[0]);
					link[home] += (double) arr[i] / (double) outlink[i];
				}

			}
		}
		double sum[] = new double[pages.length];
		double max = 0;
		for (int i = 0; i < pages.length; i++) {
			sum[i] += arr[i] + link[i];
			if (max < sum[i]) {
				answer = i;
				max = sum[i];
			}
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "blind";
		String[] pages = {
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>",
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>",
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>" };
		solution(word, pages);

	}

}
