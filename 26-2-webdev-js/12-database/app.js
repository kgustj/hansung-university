// MySQL + Node.js 접속 코드
let mysql = require("mysql2");
let db_info = {
    host: "localhost", // DB 주소
    port: "3306", // DB 포트
    user: "root", // 로그인 계정
    password: "1234", // DB 비밀번호
    database: " mydb", // 사용할 DB명
};
// root(/) 에 출력
app.get("/", (req, res) => {
    res.sendFile(__dirname + "/index.html");
});

let conn = mysql.createConnection(db_info);
conn.connect();

const express = require("express");
const app = express();
const port = 8000;

// body-parser 미들웨어(form 전송 데이터 가져오기)
const bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: true }));
app.listen(port, () => {
    console.log(` ${port} 번 포트에서 대기중...`);
});
// root(/) 에 출력
app.get("/", (req, res) => {
    res.sendFile(__dirname + "/index.html");
});

app.post("/iBoard", (req, res) => {
    const { title, content, date } = req.body;
    let insertSql = `INSERT INTO board VALUES(null, '`;
    insertSql += title + `', '` + content + `', '` + date + `');`;
    conn.query(insertSql, (err, result) => {
        if (err) console.log("query is not excuted: " + err);
        else {
            let msg = `<script type="text/javascript">`;
            msg += `alert(" 저장되었습니다");`;
            msg += `window.location.href='/list';`;
            msg += `</script>`;
            res.send(msg);
        }
    });
});

app.get("/list", (req, res) => {
    let sql = "SELECT * FROM board ORDER BY board_no DESC;";
    conn.query(sql, (err, result) => {
        if (err) console.log("query is not excuted: " + err);
        else {
            res.send(result);
            res.end();
        }
    });
});
