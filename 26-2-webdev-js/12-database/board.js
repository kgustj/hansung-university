const express = require("express");
const bodyParser = require("body-parser");
const mysql = require("mysql2");
const path = require("path");

const app = express();
const port = 8000;

app.use(bodyParser.urlencoded({ extended: true }));

// DB 연결
const conn = mysql.createConnection({
    host: "localhost",
    port: 3306,
    user: "root",
    password: "1150",
    database: "webdev",
    dateStrings: true,
});

conn.connect((err) => {
    if (err) {
        console.log("❌ DB 연결 실패: " + err.message);
        return;
    }
    console.log("✅ DB 연결 성공");
});

app.listen(port, () => {
    console.log(`✅ ${port}번 포트에서 대기중...`);
});

app.get("/", (req, res) => {
    return res.sendFile(path.join(__dirname, "board.html"));
});

app.post("/iBoard", (req, res) => {
    const { title, content, date } = req.body;
    const sql = "INSERT INTO board (title, content, date) VALUES (?, ?, ?)";
    conn.query(sql, [title, content, date], (err, result) => {
        if (err) {
            console.log("❌ 쿼리 오류: " + err.message);
            return res.status(500).json({ error: "❌ 저장 실패" });
        }
        return res.send(`
            <script>
                alert("✅ 저장되었습니다");
                location.href="/list";
            </script>
        `);
    });
});

app.get("/list", (req, res) => {
    conn.query("SELECT * FROM board ORDER BY board_no DESC", (err, result) => {
        if (err) {
            console.log("❌ 쿼리 오류: " + err.message);
            return res.status(500).json({ error: "❌ 조회 실패" });
        }
        return res.json(result);
    });
});
