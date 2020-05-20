function solution(baseball) {
  let answer = 0;

  for (let i = 123; i < 1000; i++) {
    i += "";
    let tmp = i.split("");
    if (tmp.includes("0")) continue;
    let check = false;
    for (let a = 0; a < tmp.length; a++) {
      for (let aa = 0; aa < tmp.length; aa++) {
        if (tmp[a] === tmp[aa] && a !== aa) {
          check = true;
          break;
        }
      }
      if (check) break;
    }
    if (check) continue;
    console.log(i);
    let visited = false;
    for (let s = 0; s < baseball.length; s++) {
      let st = 0;
      let ball = 0;
      baseball[s][0] += "";
      let tmp2 = baseball[s][0].split("");
      for (let j = 0; j < 3; j++) {
        for (let z = 0; z < 3; z++) {
          if (tmp[j] === tmp2[z]) {
            if (j === z) st++;
            else ball++;
          }
        }
      }
      if (baseball[s][1] !== st || baseball[s][2] !== ball) {
        visited = false;
        break;
      } else visited = true;
    }
    if (visited) answer++;
  }

  return answer;
}

const baseball = [
  [123, 1, 1],
  [356, 1, 0],
  [327, 2, 0],
  [489, 0, 1],
];
solution(baseball);
