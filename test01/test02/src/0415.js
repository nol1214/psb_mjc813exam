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
});*/

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
