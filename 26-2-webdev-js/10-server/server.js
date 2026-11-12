const http = require("http");

http.createServer((request, response) => {
    response.writeHead(200, { "Content-Type": "text/html; charset=utf-8" });
    response.write("<h1>Hello World</h1>");
    response.end("응답 종료");
}).listen(8888, () => {
    console.log("8888번 포트에서 서버 대기 중입니다.");
});
