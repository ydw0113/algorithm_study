var fs = require("fs");
var input = [4, 4];
const n = input[0];
const m = input[1];
const visited = new Array(n);
let output = [];
let result = "";
function solution(r) {
  if (r === m) {
    result += output.join("  ") + "\n";
    return;
  }
  for (let i = 0; i < n; i++) {
    if (visited[i] === true) continue;
    visited[i] = true;
    output.push(i + 1);
    solution(r + 1);
    output.pop();
    visited[i] = false;
  }
}
solution(0);

console.log(result.trim());
