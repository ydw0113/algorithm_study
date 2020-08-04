function solution(n, arr1, arr2) {
  let answer = [];
  for (let i = 0; i < n; i++) {
    let mask;
    let bit1 = "";
    let bit2 = "";
    let tmpNum = arr1[i];
    let tmpNum2 = arr2[i];
    for (let j = n - 1; j >= 0; j--) {
      mask = 1 << j;
      bit1 += tmpNum & mask ? 1 : 0;
      bit2 += tmpNum2 & mask ? 1 : 0;
    }
    let tmp = "";
    for (let j = 0; j < n; j++) {
      tmp += bit1.charAt(j) | bit2.charAt(j) ? "#" : " ";
    }
    answer.push(tmp);
  }
  return answer;
}
let arr1 = [9, 20, 28, 18, 11];
let arr2 = [30, 1, 21, 17, 28];
console.log(solution(5, arr1, arr2));

var solution = (n, a, b) =>
  a.map((a, i) =>
    (a | b[i]).toString(2).padStart(n, 0).replace(/0/g, " ").replace(/1/g, "#")
  );
