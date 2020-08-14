function solution(stones, k) {
  var answer = 0;
  let max = 0;
  let size = stones.length;
  let min = 200000000;
  for (let i = 0; i < size; i++) {
    min = Math.min(min, stones[i]);
    max = Math.max(max, stones[i]);
  }
  let left = min;
  let right = max;
  while (left <= right) {
    let mid = parseInt((left + right) / 2);
    let count = 0;
    for (let i = 0; i < size; i++) {
      if (k <= count) {
        break;
      }
      if (mid > stones[i]) {
        count++;
      } else count = 0;
    }
    if (k > count) {
      answer = mid;
      left = mid + 1;
    } else right = mid - 1;
  }
  return answer;
}

const stones = [2, 4, 5, 3, 2, 1, 4, 2, 5, 1];
console.log(solution(stones, 3));
