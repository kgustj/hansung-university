const http = require("http");
const fs = require("fs").promises;

http.createServer(async (req, res) => {
    try {
        const data = await fs.readFile("./example.html");
        res.writeHead(200, { "Content-Type": "text/html; charset=utf-8" });
        res.end(data);
    } catch (err) {
        res.writeHead(500, { "Content-Type": "text/plain; charset=utf-8" });
        res.end(err.message);
    }
}).listen(8082, () => {
    console.log("8082번 포트에서 대기 중입니다!");
});
