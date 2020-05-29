function solution(cacheSize, cities) {
  let answer = 0;
  let arr = [];
  if (cacheSize === 0) return cities.length * 5;
  for (let s of cities) {
    s = s.toLowerCase();
    if (arr.includes(s)) {
      answer += 1;
      let tmp = arr.indexOf(s);
      arr.splice(tmp, 1);
      arr.unshift(s);
    } else {
      if (arr.length === cacheSize) {
        arr.pop();
        arr.unshift(s);
        answer += 5;
      } else {
        answer += 5;
        arr.unshift(s);
      }
    }
  }
  return answer;
}

const cities = ["Jeju", "Pangyo", "NewYork", "newyork"];
solution(2, cities);
