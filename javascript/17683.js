/*
기억한 멜로디와 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개
각 음은 1분에 1개씩 재생된다
처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이
처음부터 반복해서 재생된다
음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.
음악이 00:00를 넘겨서까지 재생되는 일은 없다.
조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 
재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
조건이 일치하는 음악이 없을 때에는 `(None)`을 반환한다.
*/
function solution(m, musicinfos) {
  let answer = "(None)";
  let mu = "";
  for (let i = 0; i < m.length; i++) {
    if (m.substring(i, i + 1) === "#") continue;
    let tmp = m.substring(i, i + 2);
    if (tmp[1] === "#") {
      mu += tmp[0].toLowerCase();
    } else mu += m.substring(i, i + 1);
  }
  let size = mu.length;
  let le = 0;
  let arr = new Array(musicinfos.length);
  arr.fill(false);
  for (let i = 0; i < musicinfos.length; i++) {
    let info = musicinfos[i].split(",");
    let hour = parseInt(info[0].substring(0, 2));
    let min = parseInt(info[0].substring(3, 5));
    let sum1 = hour * 60 + min;
    let hour2 = parseInt(info[1].substring(0, 2));
    let min2 = parseInt(info[1].substring(3, 5));
    let sum2 = hour2 * 60 + min2;
    let length = sum2 - sum1;
    let s = "";
    let index = 0;
    let inMu = "";
    for (let j = 0; j < info[3].length; j++) {
      if (info[3].substring(j, j + 1) === "#") continue;
      let a = info[3].substring(j, j + 2);
      if (a[1] === "#") {
        inMu += a[0].toLowerCase();
      } else inMu += info[3].substring(j, j + 1);
    }
    let size2 = inMu.length;

    for (let j = 0; j < length; j++) {
      index = j % size2;
      s += inMu.substring(index, index + 1);
    }
    for (let j = 0; j < s.length; j++) {
      let tmp = s.substring(j, j + size);
      if (tmp === mu) {
        arr[i] = true;
        break;
      }
    }
    if (arr[i]) {
      if (le < length) {
        le = length;
        answer = info[2];
      }
    }
  }

  return answer;
}

const m = "ABC";
const musicinfos = ["13:00,13:05,WORLD1,ABCDEF", "13:00,13:06,WORLD2,ABCDEF"];
console.log(solution(m, musicinfos));
