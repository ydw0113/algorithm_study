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
  for (let i = 0; i < expression.length; i++)
    if (expression[i].match(pattern)) sign.push(expression[i]);

  let maxNum = 0;
  for (let i = 0; i < cal.length; i++) {
    let copyNum = num.slice();
    let copySign = sign.slice();
    for (let j = 0; j < cal[i].length; j++) {
      for (let k = 0; k < copySign.length; k++) {
        if (copySign[k] === cal[i][j]) {
          let tmp = copyNum[k] + copySign[k] + copyNum[k + 1];
          copyNum[k] = eval(tmp);
          copySign.splice(k, 1);
          copyNum.splice(k + 1, 1);
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

function permute(permutation) {
  var length = permutation.length,
    result = [permutation.slice()],
    c = new Array(length).fill(0),
    i = 1,
    k,
    p;
  while (i < length) {
    if (c[i] < i) {
      k = i % 2 && c[i];
      p = permutation[i];
      permutation[i] = permutation[k];
      permutation[k] = p;
      ++c[i];
      i = 1;
      result.push(permutation.slice());
    } else {
      c[i] = 0;
      ++i;
    }
  }
  return result;
}
const permutation = ["+", "*", "-"];
console.log(permute([0, 1, 2]));
console.log(combi([0, 1, 2]));

function combi(chars) {
  var result = [];
  var f = (prefix, chars) => {
    for (var i = 0; i < chars.length; i++) {
      result.push(prefix + chars[i]);
      f(prefix + chars[i], chars.slice(i + 1));
    }
  };
  f("", chars);
  return result;
}
