//17번
/*const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.question("키를 입력하세요 (cm): ", function (input) {
    const height = parseInt(input);
    if (height >= 150) {
        console.log("YES");
    } else {
        console.log("NO");
    }
    rl.close();
});

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

class Ride {
    minHeight = 150;

    constructor(height) {
        this.height = height;
    }

    checkEligibility() {
        if (this.height >= this.minHeight) {
            console.log("YES");
        } else {
            console.log("NO");
        }
    }
}
rl.question("키가 몇 cm 인가요? ", function(input) {
    let height = parseInt(input);
    let rider = new Ride(height);
    rider.checkEligibility();
    rl.close();
});

//18번 문제
const readline = require("readline");

class ScoreCalculator {
    constructor(scores) {
        this.scores = scores;
    }

    getAverage() {
        let sum = this.scores.reduce((acc, val) => acc + val, 0);
        let avg = Math.floor(sum / this.scores.length);
        console.log(avg);
    }
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.question("입력 : ", function(input) {
    let scores = input.trim().split(" ").map(Number);
    let calculator = new ScoreCalculator(scores);
    calculator.getAverage();
    rl.close();
});
*/

//25번
const readline = require("readline");

function getCircleArea(radius) {
    return radius * radius * 3.14;
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.question("반지름의 길이를 입력하세요: ", function(input) {
    let radius = parseInt(input);
    let area = getCircleArea(radius);
    console.log("원의 넓이:", area);
    rl.close();
});

































