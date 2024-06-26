const fs = require("fs");

// fs.readFile('sample.txt', (err, data) => {
//     if (err) {
//         console.log("something went wrong!");
//     }
//     else {
//         console.log(data);
//     }
// })

const data = fs.readFileSync('sample.txt',{ encoding: 'utf8', flag: 'r' });

console.log(data);