const arr = [36, 122, 79, 8, "무궁화", 391, "words", 509, 20192,
    "B", 321, 473, 73, "france", "Korea", 24, 99];

// 1. 오름차순 정렬
const sorted = [...arr].sort((a, b) =>
    a.toString().localeCompare(b.toString(), 'ko')
);
console.log("오름차순 정렬:", sorted);

// 2. 가장 큰 값
const maxVal = sorted[sorted.length - 1];
console.log("가장 큰 값:", maxVal);

//3. 짝수만 추출
const evenNumbers = arr.filter(item => typeof item === 'number' && item % 2 === 0);
console.log("짝수만 추출:", evenNumbers);