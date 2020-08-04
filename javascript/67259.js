function solution(board) {
  var answer = 0;
  let n = board.length;
  let graph = new Array(n).fill(null).map(() => new Array());
  for (let i = 0; i < n; i++) {}

  return answer;
}

function bfs() {
  let dist = new Array();
  let [cur] = pq.dequeue();
}

class PriorityQueue {
  constructor(dist) {
    this.queue = [];
    this.dist = dist;
  }

  enqueue(nodeIdx) {
    this.queue.push(nodeIdx);
  }

  dequeue() {
    let entry = 0;
    let entryIdx = this.queue[entry];

    this.queue.forEach((nodeIdx, idx) => {
      if (this.dist[entryIdx] > this.dist[nodeIdx]) {
        entryIdx = nodeIdx;
        entry = idx;
      }
    });

    return this.queue.splice(entry, 1);
  }
}

const board = [
  [0, 0, 0],
  [0, 0, 0],
  [0, 0, 0],
];
console.log(solution(board));
