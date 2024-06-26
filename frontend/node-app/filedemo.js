const http = require("http");
const fs = require("fs");

const server = http.createServer((req,resp)=> {
    fs.readFile('demo.html',(err,data)=> {
        resp.writeHead(200, {'Content-Type': 'text/html'}) 
        resp.write(data);
        resp.end();
    })  
})

server.listen(8000);
