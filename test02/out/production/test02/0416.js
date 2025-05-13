//26번
/*
const readline = require("readline");

function getPlanetEnglishName(koreanName) {
    const planetMap = {
        "수성": "Mercury",
        "금성": "Venus",
        "지구": "Earth",
        "화성": "Mars",
        "목성": "Jupiter",
        "토성": "Saturn",
        "천왕성": "Uranus",
        "해왕성": "Neptune"
    };

    return planetMap[koreanName] || "없음";
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.question("행성 이름 입력 : ", function(input) {
    const result = getPlanetEnglishName(input.trim());
    console.log("영어 이름 :", result);
    rl.close();
});*/

//19번
const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.question("두 수 a와 b를 입력하세요 (예: 2 3): ", function(input) {
    const [a, b] = input.trim().split(" ").map(Number);
    const result = Math.pow(a, b); // 또는 a ** b
    console.log(`${a}의 ${b}승은 ${result}입니다.`);
    rl.close();
});
