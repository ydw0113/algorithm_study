function solution(gems) {
  const result = new Set(gems);
  const resultSize = result.size;
  const gemsLength = gems.length;
  const nowGems = new Map();
  nowGems.set(gems[0], 1);
  let start = 0;
  let end = 0;
  let answer = [0, gemsLength - 1];

  while (end < gemsLength && start <= end) {
    if (resultSize === nowGems.size) {
      if (end - start < answer[1] - answer[0]) {
        answer = [start, end];
      }
      if (end - start === answer[1] - answer[0]) {
        if (start < answer[0]) {
          answer = [start, end];
        }
      }
      if (nowGems.get(gems[start]) > 1) {
        nowGems.set(gems[start], nowGems.get(gems[start]) - 1);
      } else {
        nowGems.delete(gems[start]);
      }
      start += 1;
    } else {
      end += 1;
      nowGems.set(gems[end], 1 + (nowGems.get(gems[end]) || 0));
    }
  }

  return [answer[0] + 1, answer[1] + 1];
}
