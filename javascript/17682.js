function solution(dartResult) {
  let dr = dartResult.match(/\d{1,2}[SDT]{1}[*|#]?/g);

  let score = [];
  for (let i = 0; i < 3; i++) {
    let num = dr[i].match(/\d{1,2}/g);
    let ch = dr[i].match(/[SDT]{1}/g);
    let kiho = dr[i].match(/[*|#]/g);

    if (ch == "S") {
      num = parseInt(num);
    } else if (ch == "D") {
      num = Math.pow(num, 2);
    } else if (ch == "T") {
      num = Math.pow(num, 3);
    }

    if (kiho == "*") {
      num = num * 2;
      if (i != 0) {
        score[i - 1] = score[i - 1] * 2;
      }
    } else if (kiho == "#") {
      num = num * -1;
    }
    score.push(num);
  }
  return score.reduce((a, b) => a + b, 0);
}
