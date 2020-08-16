function solution(N, stages) {
  let result = [];
  let answer = [];
  let stage = new Map();
  for (let i of stages) {
    if (stage.has(i)) {
      for (let j = 1; j < i; j++) {
        if (stage.has(j)) {
          var tmp = stage.get(j);
          stage.set(j, [tmp[0], tmp[1] + 1]);
        } else stage.set(j, [0, 1]);
      }
      var tmp = stage.get(i);
      stage.set(i, [tmp[0] + 1, tmp[1] + 1]);
    } else {
      for (let j = 1; j < i; j++) {
        if (stage.has(j)) {
          var tmp = stage.get(j);
          stage.set(j, [tmp[0], tmp[1] + 1]);
        } else stage.set(j, [0, 1]);
      }
      stage.set(i, [1, 1]);
    }
  }
  let max = 0;
  for (let i of stage) {
    if (i[0] > N) continue;
    result.push([i[0], i[1][0] / i[1][1]]);
    max = Math.max(i[0], max);
  }
  result.sort((a, b) => {
    if (b[1] - a[1] === 0) {
      return a[0] - b[0];
    } else return b[1] - a[1];
  });
  for (let i of result) {
    answer.push(i[0]);
  }
  console.log(stage);
  if (max < N) {
    for (let j = max + 1; j <= N; j++) {
      answer.push(j);
    }
  }
  return answer;
}

const stages = [2, 1, 2, 6, 2, 4, 3, 3];
console.log(solution(7, stages));
