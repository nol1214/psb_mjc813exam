const arr = [36, 122, 79, 8, "무궁화", 391, "words", 509, 20192, "B", 321, 473, 73, "france", "Korea", 24, 99];

// 1. 오름차순 정렬 (숫자만 추출해서)
const numbersOnly = arr.filter(item => typeof item === 'number');
const sorted = [...numbersOnly].sort((a, b) => a - b); // slice 대신 spread 사용도 OK
console.log("오름차순 정렬:", sorted);

// 2. 가장 큰 값
const maxVal = Math.max(...numbersOnly);
console.log("가장 큰 값:", maxVal);

// 3. 짝수만 추출
const evenNumbers = numbersOnly.filter(num => num % 2 === 0);
console.log("짝수만 추출:", evenNumbers);
