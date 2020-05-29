function longestChain(words) {
  // Write your code here
  let answer = 1;
  let chain = new Array(words.length);
  chain.fill(1);
  words.sort(function (a, b) {
    if (a.length === b.length) {
      if (a < b) return -1;
      else if (b < a) return 1;
      else return 0;
    } else if (a.length < b.length) {
      return -1;
    } else if (a.length > b.length) {
      return 1;
    }
  });
  console.log(words);
  for (let i = 0; i < words.length; i++) {
    let tmp = words[i].split("");
    let size = words[i].length;
    for (let j = i + 1; j < words.length; j++) {
      let check = false;
      if (size === words[j].length) continue;
      else if (size + 1 === words[j].length) {
        console.log(tmp + " " + words[j]);
        for (let s of tmp) {
          if (words[j].includes(s)) check = true;
          else {
            check = false;
            break;
          }
        }
        if (check) {
          chain[i]++;
          size = words[j].length;
          tmp = words[j].split("");
        }
      } else break;
    }
  }
  console.log(chain);
  for (let i of chain) answer = Math.max(answer, i);
  return answer;
}

const words = [
  "o",
  "a",
  "b",
  "aa",
  "aab",
  "aaa",
  "aabb",
  "aabba",
  "aaaa",
  "ab",
  "aaaaa",
  "k",
  "s",
];
longestChain(words);
