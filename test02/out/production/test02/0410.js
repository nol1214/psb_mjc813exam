let leftNumber = "";
let rightNumber = "";
let operator = "";
let result = "";

function checkWhere(number) {
    if( operator === "" ) {
        leftNumber += number.toString();
    } else {
        rightNumber += number.toString();
    }
    document.getElementById("outDiv").innerText = leftNumber + " " + operator + " " + rightNumber;
}

function buttonNum(number) {
    checkWhere(number);
}

function buttonAdd() {
    operator = "+";
}

function buttonSub() {
    operator = "-";
}

function buttonMul() {
    operator = "*";
}

function buttonDiv() {
    operator = "/";
}

function buttonEqu() {
    try {
        let res = eval(leftNumber);
    } catch(ex) {
        console.log(ex.message);
        leftNumber = leftNumber.replaceAll('A','');
    }
    let a = typeof leftNumber;
    console.log(a);
    console.log(a instanceof Number);
    try {
        let res = eval(rightNumber);
    } catch(ex) {
        console.log(ex.message);
        rightNumber = rightNumber.replaceAll('A','');
    }
    switch(operator) {
        case "+":
            result = (Number(leftNumber) + Number(rightNumber)).toString();
            break;
        case "-":
            result = (Number(leftNumber) - Number(rightNumber)).toString();
            break;
        case "*":
            result = (Number(leftNumber) * Number(rightNumber)).toString();
            break;
        case "/":
            result = (Number(leftNumber) / Number(rightNumber)).toString();
            break;
    }
    document.getElementById("outDiv").innerText = leftNumber + " " + operator
        + " " + rightNumber + " = " + result;
}

function buttonCE() {
    leftNumber = "";
    rightNumber = "";
    operator = "";
    result = "0";
    document.getElementById("outDiv").innerText = result;
}

class Car1 {
    name = "";
    construct(a) {
        this.name = a;
    }
    start() {
        console.log(this.name + " start");
    }
}

let car1 = new Car1("Fiat");
car1.start();

function Person(first, last, age, eye) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
    this.eyeColor = eye;
}

let p1 = new Person("first", "last", 20, "black");
console.log(p1);
console.log(JSON.stringify(p1));


// JavaScript 에서 클래스 선언하고 객체 탄생하는 방법으로 사용한다.
class Human {
    height = 180; // 인스턴스 변수, 멤버변수
    name = "";
    age = 0;

    constructor(name, age) {	// 비기본 생성자
        // this는 클래스가 생성할 인스턴스를 가리킨다.
        this.name = name;
        this.age = age;
    }

    print() {
        console.log("이름은 " + this.name + ", 나이는 " + this.age
            + ", 키는 " + this.height);
    }

    start() {
        console.log(this.name + " Start !!");
    }
}

let human1 = new Human("이순신", 30);
human1.print();
let human2 = new Human("홍길동", 25);
human2.print();
human2.start();

class Car {
    name = "";
    model = "";
    weight = "";
    color = "";

    constructor(name, m, w, color) {
        this.name = name;
        this.model = m;
        this.weight = w;
        this.color = color;
        // this는 클래스를 설계할때는 어떤 이름으로 인스턴스될지 모른다.
        // 인스턴스 된 자기 객체를 뜻할때 this 라는 단어를 사용한다.
    }

    start() {
        //alert(JSON.stringify(this) + " 출발합니다.");
        // JSON 문자열 형식 {이름:값, 이름:값, ...}
        // 생성된 객체의 멤버변수이름과 멤버변수 값을 출력한다.
        alert(`${JSON.stringify(this)} 출발합니다.`);
        // ` 문자열 ${자바스크립트객체,수식} 문자열`
    }

    drive() {
        console.log(this.name + " 운전합니다.");
    }

    brake() {
        console.log(this.name + " 브레이크 페달 밟아요.");
    }

    stop() {
        //console.log(this.name + " 정지합니다.");
        console.log(`${this.name} 정지합니다.`);
    }

    showRedSign() {
        console.log(this.name + " 빨간불을 봤습니다.");
        this.brake();
        this.stop();
    }
}

let fiat500 = new Car();
fiat500.name = "Fiat";  // 객체를 만든후에 멤버변수를 할당하는 방법인데
fiat500.model = "500";  // 이 방법은 별로 추천하지 않습니다.
fiat500.weight = "850kg";
fiat500.color = "white";
fiat500.start();
fiat500.drive();
fiat500.stop();

let accentMD = new Car("Accent", "MD", "700kg", "gray");
// 객체를 만들때 생성자로 객체를 생성하면서 멤버변수의 값을 할당하는 방법을 추천합니다.
accentMD.start();
accentMD.drive();
accentMD.showRedSign();

class Zeep extends Car {
    // Car 클래스를 상속받아서 Zeep 클래스를 선언한다.
    // Car 클래스에 존재하는 멤버변수와 멤버메소드를 모두 사용할 수 있다.
    engine = "";
    constructor(name, m, w, color, engine) {
        super(name, m, w, color);
        this.engine = engine;
    }
    fourWd() {
        console.log(this.name + ", " + this.engine + " 4휠 입니다.");
    }
}

let zeep1 = new Zeep("코란도4", "코란도", "1200kg", "brown", "120마력");
zeep1.start();
zeep1.drive();
zeep1.fourWd();
zeep1.stop();
// 자식클래스 객체는 부모클래스의 속성(멤버변수)와 메소드(멤버메소드)를 사용할 수 있다.
// 그리고 자식클래스의 속성과 메소드를 사용할 수 있다.


let morning1 = new Car("모닝", "M500", "700kg", "red");
morning1.start();
morning1.drive();
// morning1.fourWd();  // 에러가 발생합니다.
// 부모클래스 객체는 부모클래스만 사용할 수 있다.
// 부모클래스 객체는 자식클래스를 모른다.
morning1.stop();

const arr = [36, 122, 79, 8, "무궁화", 391, "words", 509, 20192, "B", 321, 473, 73, "france", "Korea", 24, 99];

// 1. 오름차순 정렬 (숫자만 추출해서)
const numbersOnly = arr.filter(item => typeof item === 'number');
const sorted = numbersOnly.slice().sort((a, b) => a - b);
console.log("오름차순 정렬:", sorted);

// 2. 가장 큰 값
const maxVal = Math.max(...numbersOnly);
console.log("가장 큰 값:", maxVal);

// 3. 짝수만 추출
const evenNumbers = numbersOnly.filter(num => num % 2 === 0);
console.log("짝수만 추출:", evenNumbers);