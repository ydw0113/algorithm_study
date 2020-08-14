function solution(expression) {
  const cal = [
    ["+", "-", "*"],
    ["+", "*", "-"],
    ["-", "+", "*"],
    ["-", "*", "+"],
    ["*", "-", "+"],
    ["*", "+", "-"],
  ];

  let pattern = /[^0-9]/;
  let num = expression.split(pattern);
  let sign = [];
  for (let i = 0; i < expression.length; i++) {
    if (expression[i].match(pattern)) sign.push(expression[i]);
  }

  let maxNum = 0;
  for (let i = 0; i < cal.length; i++) {
    let copyNum = num.slice();
    let copySign = sign.slice();
    for (let j = 0; j < cal[i].length; j++) {
      for (let k = 0; k < copySign.length; k++) {
        if (cal[i][j] === copySign[k]) {
          let tmp = copyNum[k] + copySign[k] + copyNum[k + 1];
          copyNum[k] = eval(tmp);
          copyNum.splice(k + 1, 1);
          copySign.splice(k, 1);
          k--;
        }
      }
    }
    maxNum = Math.max(maxNum, Math.abs(copyNum[0]));
  }

  return maxNum;
}

const expression = "100-200*300-500+20";
console.log(solution(expression));
