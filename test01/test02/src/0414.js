/*## 4월 14일 문제
1번 로또 만들기
1~45번 까지의 숫자 5개 + 보너스1개 를 랜덤으로 만든다.
    중복된 숫자는 제거한다.
    숫자 6개 저장되는 배열 선언하여 오름차순으로 정렬한다.
Math.random()
곱하기
Math.ceil(값)

2번 문제10번 별찍기
3번 문제12번 게임캐릭터클래스
4번 문제13번 let strInput = prompt("입력하세요");
5번 문제16번

function generateLotto() {
    const lotto = new Set();
    while (lotto.size < 6) {
        const num = Math.ceil(Math.random() * 45);
        lotto.add(num);
    }
    const lottoArray = Array.from(lotto).sort((a, b) => a - b);
    const bonus = lottoArray.pop();
    console.log("로또 번호 :", lottoArray);
    console.log("보너스 번호:", bonus);
}
generateLotto();

function printPyramid(levels) {
    for (let i = 1; i <= levels; i++) {
        const space = ' '.repeat(levels - i);
        const stars = '*'.repeat(2 * i - 1);
        console.log(space + stars);
    }
}
printPyramid(5);

class Wizard {
    constructor(health, mana, armor) {
        this.health = health;
        this.mana = mana;
        this.armor = armor;
    }

    attack() {
        console.log("파이어볼");
    }
}

const x = new Wizard(545, 210, 10);
console.log(x.health, x.mana, x.armor);
x.attack();


const planets = ["수성", "금성", "지구", "화성", "목성", "토성", "천왕성", "해왕성"];
let strInput = prompt("입력하세요");
let input = parseInt(strInput);
console.log(planets[input - 1]);
*/

const readline = require("readline");

const planets = ["수성", "금성", "지구", "화성", "목성", "토성", "천왕성", "해왕성"];

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.question("(1~8) : ", function (input) {
    const index = parseInt(input);

    if (index >= 1 && index <= 8) {
        console.log(`${planets[index - 1]}입니다.`);
    } else {
        console.log("(1~8) : ");
    }

    rl.close();
});


