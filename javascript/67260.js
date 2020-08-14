let graph;
let prior;
let visited;
let hang;
function solution(n, path, order) {
  graph = Array(n)
    .fill(null)
    .map(() => Array());
  prior = Array(n)
    .fill(null)
    .map(() => Array());
  visited = new Array(n);
  hang = new Array(n);
  for (let e of path) {
    graph[e[0]].push(e[1]);
    graph[e[1]].push(e[0]);
  }
  for (let i of order) prior[i[1]].push(i[0]);

  if (prior[0] > 0) return false;

  visited[0] = true;
  for (let i of graph[0]) dfs(i);
  console.log(visited);
  for (let i = 0; i < n; i++) {
    if (!visited[i]) return false;
  }
  return true;
}

function dfs(i) {
  if (visited[i]) return;
  if (!visited[prior[i]]) {
    hang[prior[i]] = i;
    return;
  }
  visited[i] = true;
  dfs(hang[i]);
  for (let v of graph[i]) dfs(v);
}

const path = [
  [0, 1],
  [0, 3],
  [0, 7],
  [8, 1],
  [3, 6],
  [1, 2],
  [4, 7],
  [7, 5],
];
const order = [
  [8, 5],
  [6, 7],
  [4, 1],
];
const n = 9;
console.log(solution(n, path, order));
