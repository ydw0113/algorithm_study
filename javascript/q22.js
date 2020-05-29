function getMostVisited(n, sprints) {
  // Write your code here
  let answer = 0;
  let arr = new Array(n + 1);
  arr.fill(0);
  let arr2 = new Array(n + 1);
  arr2.fill(0);
  let arr3 = new Array(n + 1);
  arr3.fill(0);
  for (let i = 0; i < sprints.length - 1; i++) {
    let x = sprints[i];
    let y = sprints[i + 1];
    if (x > y) {
      let tmp = x;
      x = y;
      y = tmp;
    }
    arr[x] += 1;
    if (y < n) {
      arr2[y + 1] -= 1;
    }
  }
  let cur = 0;
  console.log(arr);
  console.log(arr2);
  for (let i = 1; i < n + 1; i++) {
    cur = cur + arr[i] + arr2[i];
    console.log(cur);
    arr3[i] = cur;
    console.log(arr3);
  }
  let max = 0;
  for (let i = 1; i < n + 1; i++) {
    if (max < arr3[i]) {
      max = arr3[i];
      answer = i;
    }
  }
  console.log(answer);
  return answer;
}

const sprints = [1, 5, 10, 3];
getMostVisited(10, sprints);
