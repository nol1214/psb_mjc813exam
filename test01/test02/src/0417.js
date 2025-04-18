class Exam37 {
    arrItem = [];
    maps = new Map();
    constructor(input) {
        this.arrItem = input.split(" ");
    }
    checkVotes() {
        for( let i = 0; i < this.arrItem.length; i++ ) {
            if ( this.isExistItem(this.arrItem[i]) ) {
                // map 에 원소이름의 키가 있을때 실행한다.
                let number = this.maps.get(this.arrItem[i]);
                // map 에서 원소이름이 키인 원래값을 가져온다.
                this.maps.set(this.arrItem[i], number + 1);
                // map 에 {원소이름: 원래값+1} 으로 저장 한다
                // this.maps.set( 키, 값 );
            } else {
                // map 에 원소이름의 키가 없을때 실행한다.
                this.maps.set(this.arrItem[i], 1);
                // map 에 {원소이름: 1} 으로 저장 한다
                // this.maps.set( 키, 값 );
            }
        }
        console.log(this.maps);
        console.log([...this.maps]);    // [... JavaScript Map, Set, Array] ===> 배열로 변환
        let item = [...this.maps].reduce( (a,b) =>  // Array reduce 사용
            a[1] >= b[1] ? a : b    // 앞의 원소 a[1] 값 >= 뒤의 원소 b[1] 값 보다 크면 a 를 리턴
        );
        return item;
        // return 가장 [1] 값이 큰 map 원소를 리턴한다.
    }
    isExistItem(item) {
        // 원소가 maps 에 키로 존재하면 true 를 리턴한다.
        return this.maps.has(item);
        // if ( this.maps.has(item) == true )
    }
}
let exam37 = new Exam37(prompt("투표할 항목을 공백으로 구분해서 입력하세요."));
let result = exam37.checkVotes();
console.log(`투표 결과 ${result[0]}가 ${result[1]}표로 가장 많습니다.`);