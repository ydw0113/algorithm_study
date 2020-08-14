let result = 0;
const array = [];

function solution(user_id, banned_id) {
  var answer = 0;
  const banned_list = banned_id.map((bannedId) => bannedId.replace(/\*/g, "."));
  const visit = [...user_id].fill(false);
  dfs(user_id, banned_list, 0, 0, visit);
  answer = result;
  return answer;
}
function dfs(user_id, banned_id, idx, n, visit) {
  const visited = [...visit];
  const regex = RegExp(`\^${banned_id[idx]}\$`);
  if (n === banned_id.length) {
    const tmp = [];
    visited.forEach((value, i) => value && tmp.push(user_id[i]));
    let cnt = 0;
    array.forEach((el) => {
      let flag;
      for (let i of tmp) {
        flag = el.some((v) => v === i);
        if (!flag) break;
      }
      !flag && cnt++;
    });
    if (array.length === cnt) {
      result++;
      array.push(tmp);
    }
  }

  user_id.filter((id, index) => {
    if (regex.test(id)) {
      if (!visited[index]) {
        visited[index] = true;
        dfs(user_id, banned_id, idx + 1, n + 1, visited);
        visited[index] = false;
      }
    }
  });
}

const user_id = ["frodo", "fradi", "crodo", "abc123", "frodoc"];
const banned_id = ["fr*d*", "*rodo", "******", "******"];

console.log(solution(user_id, banned_id));
