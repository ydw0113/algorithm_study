function solution(m, n, board) {
  let answer = 0;
  let flag = true;

  let visited = new Array(m);
  for (let i = 0; i < m; i++) {
    visited[i] = new Array(n);
    for (let j = 0; j < n; j++) {
      visited[i][j] = board[i].charCodeAt(j);
    }
  }
  board = JSON.parse(JSON.stringify(visited));
  while (flag) {
    flag = false;
    for (let i = 0; i < m; i++) {
      for (let j = 0; j < n; j++) {
        let tmp = board[i][j];
        if (i + 1 >= m || j + 1 >= n || tmp === 0) continue;
        if (
          tmp === board[i + 1][j] &&
          tmp === board[i + 1][j + 1] &&
          tmp === board[i][j + 1]
        ) {
          answer += 4;
          if (visited[i][j] === 0) answer--;
          if (visited[i + 1][j] === 0) answer--;
          if (visited[i][j + 1] === 0) answer--;
          if (visited[i + 1][j + 1] === 0) answer--;
          visited[i + 1][j] = 0;
          visited[i + 1][j + 1] = 0;
          visited[i][j + 1] = 0;
          visited[i][j] = 0;
          flag = true;
        }
      }
    }
    for (let i = 0; i < n; i++) {
      let count = 0;
      for (let j = m - 1; j >= 0; j--) {
        if (visited[j][i] !== 0 && count > 0) {
          visited[j + count][i] = visited[j][i];
          visited[j][i] = 0;
          count = count - 1;
        }
        if (visited[j][i] === 0) count++;
      }
    }
    board = JSON.parse(JSON.stringify(visited));
  }
  return answer;
}

const board = ["CCBDE", "AAADE", "AAABF", "CCBBF"];
console.log(solution(4, 5, board));
