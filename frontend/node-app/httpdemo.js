
const http = require("http");

const server = http.createServer((req,resp)=> {

    resp.writeHead(200, {'Content-Type': 'text/plain'}) 
    resp.end("<h2>Hello World!!!!!!</h2>");
})

server.listen(8000);
