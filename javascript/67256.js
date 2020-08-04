function solution(numbers, hand) {
  let answer = "";
  let leftPos = [3, 1];
  let rightPos = [3, 1];
  let position;

  numbers.forEach((number) => {
    if (number === 0) number = 12;
    number -= 1;
    let tmp = parseInt(number / 3);
    if (number === 0 || number === 3 || number === 6) {
      answer += "L";
      leftPos = [tmp, 1];
    } else if (number === 2 || number === 5 || number === 8) {
      answer += "R";
      rightPos = [tmp, 1];
    } else {
      if (
        Math.abs(leftPos[0] - tmp) + leftPos[1] >
        Math.abs(rightPos[0] - tmp) + rightPos[1]
      ) {
        answer += "R";
        rightPos = [tmp, 0];
      } else if (
        Math.abs(leftPos[0] - tmp) + leftPos[1] <
        Math.abs(rightPos[0] - tmp) + rightPos[1]
      ) {
        answer += "L";
        leftPos = [tmp, 0];
      } else {
        if (hand === "right") {
          answer += "R";
          rightPos = [tmp, 0];
        } else {
          answer += "L";
          leftPos = [tmp, 0];
        }
      }
    }
  });
  console.log(answer);
  return answer;
}

const numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5];
const hand = "right";
solution(numbers, hand);
