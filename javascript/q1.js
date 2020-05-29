function numPlayers(k, scores) {
  // Write your code here
  let answer = 0;
  let arr = [];
  let index = 1;
  scores.sort(function (a, b) {
    return b - a;
  });
  let tmp = scores[0];
  for (let i = 0; i < scores.length; i++) {
    if (tmp === scores[i]) {
      arr.push(index);
    } else {
      index = i + 1;
      arr.push(index);
    }
    tmp = scores[i];
  }
  console.log(arr);
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] <= k && scores[i] > 0) answer++;
  }
  console.log(answer);
}
const scores = [20, 40, 60, 80, 100];
numPlayers(4, scores);
