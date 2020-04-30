// 셔틀은 09:00부터 총 n회 t분 간격으로 역에 도착하며
// 하나의 셔틀에는 최대 m명의 승객이 탈 수 있다.
// 셔틀은 도착했을 때 도착한 순간에 대기열에 선 크루까지 포함해서 대기 순서대로 태우고 바로 출발한다.
// 예를 들어 09:00에 도착한 셔틀은 자리가 있다면 09:00에 줄을 선 크루도 탈 수 있다
function solution(n, t, m, timetable) {
  let answer = "";
  let count = 0;
  let bus = 540;
  let max = 0;
  let flag = false;
  timetable.sort();
  let visited = new Array();
  for (let i = 0; i < n; i++) {
    count = 0;
    if (n === 1) {
      for (let j of timetable) {
        let min = j.substring(0, 2) * 60;
        let sec = j.substring(3, 5);
        let sum = parseInt(min) + parseInt(sec);
        if (sum <= bus) {
          max = Math.max(max, sum);
          count++;
          if (count === m) {
            var a = parseInt(max / 60);
            var b = (max % 60) - 1;
            if (b < 0) {
              b = 60 + b;
              a--;
            }
            if (a < 10) {
              if (b < 10) {
                answer = "0" + a + ":" + "0" + b;
              } else answer = "0" + a + ":" + b;
            } else if (b < 10) {
              answer = a + ":" + "0" + b;
            } else answer = a + ":" + b;
            flag = true;
            break;
          }
        }
      }
      if (flag) break;
      else answer = "09:00";
    } else {
      for (let j = 0; j < timetable.length; j++) {
        if (visited[j]) continue;
        let min = timetable[j].substring(0, 2) * 60;
        let sec = timetable[j].substring(3, 5);
        let sum = parseInt(min) + parseInt(sec);
        if (sum <= bus) {
          max = Math.max(max, sum);
          count++;
          visited[j] = true;
          if (i + 1 === n) {
            if (count === m) {
              var a = parseInt(max / 60);
              var b = (max % 60) - 1;
              if (b < 0) {
                b = 60 + b;
                a--;
              }
              if (a < 10) {
                if (b < 10) {
                  answer = "0" + a + ":" + "0" + b;
                } else answer = "0" + a + ":" + b;
              } else if (b < 10) {
                answer = a + ":" + "0" + b;
              } else answer = a + ":" + b;
              flag = true;
              break;
            }
          } else if (count === m) break;
        }
      }
      if (!flag) {
        var a = parseInt((540 + (n - 1) * t) / 60);
        var b = (540 + (n - 1) * t) % 60;
        if (b < 0) {
          b = 60 + b;
          a--;
        }
        if (a < 10) {
          if (b < 10) {
            answer = "0" + a + ":" + "0" + b;
          } else answer = "0" + a + ":" + b;
        } else if (b < 10) {
          answer = a + ":" + "0" + b;
        } else answer = a + ":" + b;
      }
    }
    bus += t;
  }
  return answer;
}

const timetable = [
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
  "23:59",
];
console.log(solution(10, 60, 45, timetable));
