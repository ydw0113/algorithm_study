function solution(board) {
  let answer = 0;
  let road = {
    x: 0,
    y: 0,
    cost: 0,
    dir: -1,
  };
  let n = board.length;
  answer = bfs(road, n, board);
  return answer;
}

function bfs(road, n, board) {
  const dx = [-1, 0, 1, 0];
  const dy = [0, -1, 0, 1];
  const q = new Array(road);
  board[0][0] = 1;
  let minCost = Number.MAX_VALUE;
  while (q.length > 0) {
    let d = q.shift();
    if (d.x === n - 1 && d.y === n - 1) {
      minCost = Math.min(minCost, d.cost);
      continue;
    }
    for (let i = 0; i < 4; i++) {
      let nx = d.x + dx[i];
      let ny = d.y + dy[i];
      if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] !== 1) {
        let newCost = 0;
        if (d.dir === -1 || d.dir === i) newCost = d.cost + 100;
        else if (d.dir !== i) newCost = d.cost + 600;

        if (board[nx][ny] === 0) {
          board[nx][ny] = newCost;
          q.push({ x: nx, y: ny, cost: newCost, dir: i });
        } else if (board[nx][ny] >= newCost) {
          board[nx][ny] = newCost;
          q.push({ x: nx, y: ny, cost: newCost, dir: i });
        }
      }
    }
  }
  console.log(board);
  return minCost;
}

const board = [
  [0, 0, 0],
  [0, 0, 0],
  [0, 0, 0],
];

console.log(solution(board));
