const express = require("express");
const bodyParser = require("body-parser");

const app = express();
const port = 8000;

app.use(bodyParser.urlencoded({ extended: true }));

app.listen(port, () => {
    console.log(`${port}번 포트에서 대기중...`);
});

app.get("/", (req, res) => {
    res.sendFile(__dirname + "/board.html");
});

function getPost(res, data) {
    let message = `<h3>제목: ${data.title}</h3>`;
    message += `<p style="white-space: pre-wrap">내용: ${data.content}</p>`;
    message += `<p>작성일: ${data.date}</p>`;
    res.send(message);
}

// 실습 2-1: GET - query → /board?title=제목&content=본문&date=날짜
app.get("/board", (req, res) => {
    console.log(req.query);
    getPost(res, req.query);
});

// 실습 2-2: GET - parameter → /board/제목/내용/날짜
app.get("/board/:title/:content/:date", (req, res) => {
    console.log(req.params);
    getPost(res, req.params);
});

// 실습 2-3: POST - body → /board (값은 요청 본문에)
app.post("/board", (req, res) => {
    console.log(req.body);
    getPost(res, req.body);
});

// 실습 2-4: POST - parameter → /board/제목/내용/날짜
app.post("/board/:title/:content/:date", (req, res) => {
    console.log(req.params);
    getPost(res, req.params);
});
