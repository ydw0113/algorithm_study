function solution(s) {
  let answer = [];
  let sets = new Set();
  let tupples = s
    .slice(2, s.length - 2)
    .split("},{")
    .map((el) => el.split(","));
  tupples.sort((a, b) => a.length - b.length);
  for (let i = 0; i < tupples.length; i++) {
    for (let tupple of tupples[i]) sets.add(tupple);
  }
  for (let set of sets) answer.push(parseInt(set));
  return answer;
}
const s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

console.log(solution(s));
