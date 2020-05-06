function solution(board) {
  let answer = 0;
  const robot = {
    x: 1,
    y: 0,
    d: 0,
  };
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      if (board[i][j] === 1) board[i][j] = -1;
    }
  }
  let visited = JSON.parse(JSON.stringify(board));
  bfs(robot, board, visited);
  answer = board[board.length - 1][board.length - 1];
  return answer;
}
function bfs(robot, board, visited) {
  let q = new Array(robot);
  let dx = [1, 0];
  let dy = [0, 1];
  visited[0][0] = -1;
  visited[0][1] = -1;
  while (q.length > 0) {
    const ro = q.shift();
    for (let i = 0; i < 2; i++) {
      let nx = ro.x + dx[i];
      let ny = ro.y + dy[i];
      if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length)
        continue;
      if (board[ny][nx] === -1) {
        continue;
      }
      if (dy[i] === 1 && ro.d === 0) {
        if (ro.y + 1 >= board.length || ro.x - 1 < 0) {
          if (board[ro.y + 1][ro.x - 1] === -1) {
            if (ro.x + 1 >= board.length) continue;
            if (board[ro.y + 1][ro.x + 1] === -1) continue;
          }
        }
      } else if (dx[i] === 1 && ro.d === 1) {
        if (ro.x + 1 >= board.length) continue;
        if (board[ro.y][ro.x + 1] === -1) {
          if (ro.y + 1 >= board.length) continue;
          if (board[ro.y + 1][ro.x + 1] === -1) continue;
        }
      }
      board[ny][nx] = board[ro.y][ro.x] + 1;
      visited[ny][nx] = -1;
      if (dy[i] === 1) q.push({ x: nx, y: ny, d: 1 });
      else if (dx[i] === 1) q.push({ x: nx, y: ny, d: 0 });
    }
  }
}

const board = [
  [0, 0, 0, 1, 1],
  [0, 0, 0, 1, 0],
  [0, 1, 0, 1, 1],
  [1, 1, 0, 0, 1],
  [0, 0, 0, 0, 0],
];
console.log(solution(board));
