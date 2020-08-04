function solution(gems) {
  const result = new Set(gems);
  const resultSize = result.size;
  const gemsLength = gems.length;

  const nowGems = new Map(); // 보석들을 담아둘 Map
  nowGems.set(gems[0], 1); // 처음 gems을 넣어둔다.

  let start = 0;
  let end = 0;
  let answer = [0, gemsLength - 1]; //제일 길 때의 답.

  while (end < gemsLength && start <= end) {
    // Map은 size를 통해 key의 개수를 알 수 있다. 같을 경우 모든 보석들이 있는 것이다.
    // 길이를 비교해서 answer를 정하고 같을 경우 start 지점이 빠른걸로 answer를 정한다.
    if (resultSize === nowGems.size) {
      if (end - start < answer[1] - answer[0]) {
        answer = [start, end];
      }
      if (end - start === answer[1] - answer[0]) {
        if (start < answer[0]) {
          answer = [start, end];
        }
      }
      // 만약 해당 보석의 개수가 2개 이상이면 -1을 해주고 1개였을 경우 빼야 하므로 delete 시켜준다.
      if (nowGems.get(gems[start]) > 1) {
        nowGems.set(gems[start], nowGems.get(gems[start]) - 1);
      } else {
        nowGems.delete(gems[start]);
      }
      start += 1;
    }
    // 만약 end 지점의 보석이 있을 경우 1로, 없을 경우 원래 값에서 + 1을 해준다.
    else {
      end += 1;
      nowGems.set(gems[end], 1 + (nowGems.get(gems[end]) || 0));
    }
  }

  return [answer[0] + 1, answer[1] + 1];
}
