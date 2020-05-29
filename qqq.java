package study;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class qqq {
    public static int droppedRequests(List<Integer> requestTime) {
		int answer =0;
		int sum=1;
		int index = requestTime.get(0);
		int cnt =1;
		int sum2=1;
		int arr[] =new int[requestTime.get(requestTime.size()-1)];
		Arrays.fill(arr, 0);
		int arr2[] =new int[requestTime.get(requestTime.size()-1)];
		Arrays.fill(arr2, 0);
		arr[index]++;
		arr2[index]++;
		boolean check2 =true;
		  for (int i = 1; i < requestTime.size(); i++) {
			    boolean check = true;
			    if (index == requestTime.get(i)) {
			      cnt++;
			      if (cnt > 3 && check2) {
			        answer++;
			        check = false;
			      }
			    } else if (index != requestTime.get(i)) {
			      cnt = 1;
			      int time = index;
			      index = requestTime.get(i);
			      for (int j = time; j <= index; j++) {
			        if (arr[j - 10] > 0) {
			          sum -= arr[j - 10];
			          arr[j - 10] = 0;
			        }
			        if (arr2[j - 60] > 0) {
			          sum2 -= arr2[j - 60];
			          arr2[j - 60] = 0;
			        }
			      }
			    }
			    sum++;
			    sum2++;
			    arr[index]++;
			    arr2[index]++;

			    if (sum > 20 && check) {
			      answer++;
			      check2 = false;
			    } else check2 = true;
			    if (sum2 > 60 && check && check2) {
			      answer++;
			    }
			  }
			  return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
