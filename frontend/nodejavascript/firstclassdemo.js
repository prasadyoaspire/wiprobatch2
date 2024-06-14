let i = 10;
let name = "Raj";

//function assigned as a value to the variable
let myFun = function () {
    return "test function";
}

console.log(i);
console.log(name);
console.log(myFun);

const r = myFun();
console.log(r);

// a function returns another function
function sample() {
    let i = 20;

    return function () {
        return "function returns another function";
    }
}

//a funciton definition which takes another function as an argument 
function demo(a, b) {
   console.log("outer funciton")
    b();
}

//function calling
demo(10, function () {
    console.log("fun fun fun");
});
