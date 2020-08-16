function solution(record) {
  let result = new Map();
  let answer = [];
  for (let i of record) {
    let tmp = i.split(" ");
    if (tmp[0] !== "Leave") result.set(tmp[1], tmp[2]);
  }
  console.log(result);
  for (let i of record) {
    let tmp = i.split(" ");
    if (tmp[0] === "Enter")
      answer.push(result.get(tmp[1]) + "님이 들어왔습니다.");
    else if (tmp[0] === "Leave")
      answer.push(result.get(tmp[1]) + "님이 나갔습니다.");
  }

  return answer;
}

const record = [
  "Enter uid1234 Muzi",
  "Enter uid4567 Prodo",
  "Leave uid1234",
  "Enter uid1234 Prodo",
  "Change uid4567 Ryan",
];

console.log(solution(record));
