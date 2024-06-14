function fun2(...b) {
    let sum = 0;
    for(let i=0;i<b.length;i++) {
        sum = sum+b[i];
    }
    return sum;
}

const r1 = fun2(10,20);
console.log(r1);

const r2 = fun2(10,20,30);
console.log(r2);

const r3 = fun2(10,20,30,40);
console.log(r3);