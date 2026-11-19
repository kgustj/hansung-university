const express = require("express");
const bodyParser = require("body-parser");

const app = express();
const port = 8000;

app.use(bodyParser.urlencoded({ extended: true }));

app.listen(port, () => {
    console.log(`${port}번 포트에서 대기중...`);
});

app.get("/", (req, res) => {
    res.sendFile(__dirname + "/user.html");
});

function getMember(res, data) {
    let message = `<h3>이름: ${data.name}</h3>`;
    message += `<h3>나이: ${data.age}</h3>`;
    res.send(message);
}

// 실습 1-1: GET - query → /users?name=한가을&age=9
app.get("/users", (req, res) => {
    console.log(req.query);
    getMember(res, req.query);
});

// 실습 1-2: GET - parameter → /users/한가을/9
app.get("/users/:name/:age", (req, res) => {
    console.log(req.params);
    getMember(res, req.params);
});

// 실습 1-3: POST - body → /users
app.post("/users", (req, res) => {
    console.log(req.body);
    getMember(res, req.body);
});

// 실습 1-4: POST - parameter → /users/한가을/9
app.post("/users/:name/:age", (req, res) => {
    console.log(req.params);
    getMember(res, req.params);
});
