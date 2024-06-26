const mysql = require("mysql2");

const con = mysql.createConnection({
    host : "localhost",
    port : 3306,
    user : 'root',
    password: 'root123',
    database : "wiprobatch2db"
})

con.connect(err=> {
    if(err) {
        console.log("Error while connecting "+err);
    }
    else {
        console.log("connected!");
    }   
})

