function solution(brown, yellow) {
  var answer = [];
  let tmp = brown + yellow;
  let arr = new Map();
  let visited = [];
  for (let i = 1; i <= tmp; i++) {
    if (tmp % i === 0) {
      if (visited[i]) continue;
      visited[tmp / i] = true;
      visited[i] = true;
      arr.set(tmp / i, i);
    }
  }
  for (let a of arr) {
    if (a[0] * 2 + (a[1] - 2) * 2 === brown) {
      console.log(a);
    }
  }
  return answer;
}

solution(10, 2);
