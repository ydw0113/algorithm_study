/*취약 지점의 위치는 정북 방향 지점으로부터 시계 방향으로 떨어진 거리로 나타냅니다. 
  친구들은 출발 지점부터 시계,혹은 반시계 방향으로 외벽을 따라서만 이동합니다.
  친구 수의 최소값을 return
*/
let min = Number.MAX_SAFE_INTEGER;

function solution(n, weak, dist) {
  let answer = 0;
  let arr = [];
  let com = [];
  com[0] = weak;
  for (let i = 1; i < weak.length; i++) {
    com[i] = [];
    for (let j = 0; j < weak.length; j++) {
      com[i].push(com[i - 1][j]);
      if (i === j) {
        var tmp = com[i].shift();
      }
    }
    com[i].push(tmp + n);
  }
  for (let i = 1; i <= dist.length; i++) {
    for (let j = 0; j < com.length; j++) {
      let w = com[j];
      permu(arr, dist.length, i, dist, 0, 0, w);
    }
  }
  if (min === Number.MAX_SAFE_INTEGER) answer = -1;
  else answer = min;
  return answer;
}

function permu(arr, n, r, dist, index, target, w) {
  if (r === 0) {
    let count = 0;
    let index = 0;
    let visited = new Array(n);
    visited.fill(0);
    for (let i of arr) {
      for (let j = index; j < w.length; j++) {
        if (visited[j] === 1) continue;
        if (w[index] - w[j] <= i) {
          count += 1;
          index++;
          visited[j] = 1;
          i = i - w[j + 1] - w[j];
        } else {
          continue;
        }
      }
    }
    if (count === w.length) {
      min = Math.min(min, arr.length);
    }
    return;
  }
  if (target === n) return;
  arr[index] = dist[target];
  permu(arr, n, r - 1, dist, index + 1, target + 1, w);
  permu(arr, n, r, dist, index, target + 1, w);
}

const weak = [1, 5, 6, 10];
const dist = [1, 2, 3, 4];
console.log(solution(12, weak, dist));
