function droppedRequests(requestTime) {
  // Write your code here
  let answer = 0;
  let sum = 1;
  let index = requestTime[0];
  let cnt = 1;
  let sum2 = 1;
  let arr = new Array(requestTime[requestTime.length - 1] + 1);
  arr.fill(0);
  arr[index]++;
  let arr2 = new Array(requestTime[requestTime.length - 1] + 1);
  arr2.fill(0);
  arr2[index]++;
  let check2 = true;
  for (let i = 1; i < requestTime.length; i++) {
    let check = true;
    if (index === requestTime[i]) {
      cnt++;
      if (cnt > 3 && check2) {
        answer++;
        check = false;
      }
    } else if (index !== requestTime[i]) {
      cnt = 1;
      let time = index;
      index = requestTime[i];
      for (let j = time; j <= index; j++) {
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
    console.log(
      sum +
        " " +
        cnt +
        " " +
        requestTime[i] +
        " " +
        answer +
        " " +
        arr[index - 10] +
        " " +
        arr[index] +
        " " +
        index
    );
  }
  console.log(answer);
  return answer;
}

const requestTime = [
  1,
  1,
  1,
  1,
  2,
  2,
  2,
  3,
  3,
  3,
  4,
  4,
  4,
  5,
  5,
  5,
  6,
  6,
  6,
  7,
  7,
];
droppedRequests(requestTime);
