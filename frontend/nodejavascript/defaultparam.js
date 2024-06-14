function fun1(a,b=1) {
    console.log("a = "+a);
    console.log("b = "+b);
    return a+b;
}

const result1 = fun1(10,50);
console.log(result1);