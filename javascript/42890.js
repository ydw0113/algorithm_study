function solution(relation) {
  let answer = 0;
  size = relation[0].length;
  let li = [];
  for (let i = 1; i < 1 << size; i++) {
    let flag = true;
    let list = [];
    for (let j = 0; j < size; j++) {
      if ((i & (1 << j)) > 0) list.push(j);
    }
    if (solve(list, relation)) {
      for (let a of li) {
        if ((a & i) === a) {
          flag = false;
          break;
        }
      }
      if (flag) {
        li.push(i);
        answer++;
      }
    }
  }
  return answer;
}

function solve(list, relation) {
  let flag = true;
  let count = 0;
  for (let i = 0; i < relation.length; i++) {
    let tmp = "";
    for (let a of list) tmp += relation[i][a];
    for (let j = i + 1; j < relation.length; j++) {
      let tmp2 = "";
      for (let a of list) tmp2 += relation[j][a];
      if (tmp === tmp2) {
        flag = false;
        break;
      }
    }
    if (flag) count++;
  }
  console.log(count);
  return flag;
}
const relation = [
  ["100", "ryan", "music", "2"],
  ["200", "apeach", "math", "2"],
  ["300", "tube", "computer", "3"],
  ["400", "con", "computer", "4"],
  ["500", "muzi", "music", "3"],
  ["600", "apeach", "music", "2"],
];

console.log(solution(relation));
