function getMostVisited(n, sprints) {
  // Write your code here
  let size = sprints.length;
  let index = 0;
  let arr = new Array(n);
  arr.fill(0);
  let max = 0;
  while (size > 1) {
    if (sprints[index] < sprints[index + 1]) {
      for (let i = sprints[index] - 1; i <= sprints[index + 1] - 1; i++) {
        arr[i]++;
        max = Math.max(max, arr[i]);
      }
    } else {
      for (let i = sprints[index] - 1; i >= sprints[index + 1] - 1; i--) {
        arr[i]++;
        max = Math.max(max, arr[i]);
      }
    }
    index++;
    size--;
  }

  let answer = 0;
  console.log(arr);
  for (let i = 0; i < arr.length; i++) {
    if (max <= arr[i]) {
      answer = i + 1;
      break;
    }
  }
  console.log(answer);
  return answer;
}

const sprints = [1, 5];
getMostVisited(5, sprints);
