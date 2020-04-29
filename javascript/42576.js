function solution(participant, completion) {
  let answer = "";
  let map = new Map();
  for (let part of participant) {
    if (map.has(part)) map.set(part, map.get(part) + 1);
    else map.set(part, 1);
  }
  for (let com of completion) {
    map.set(com, map.get(com) - 1);
  }
  for (let part of participant) {
    if (map.get(part) === 1) answer = part;
  }
  return answer;
}

const a = ["leo", "kiki", "eden"];
const b = ["eden", "kiki"];
console.log(solution(a, b));
