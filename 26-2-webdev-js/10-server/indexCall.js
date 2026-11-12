const express = require("express");
const app = express();

app.set("port", process.env.PORT || 3003);
app.listen(app.get("port"), () => {
    console.log(app.get("port"), "번 포트 대기 중");
});

app.get("/", (req, res) => {
    console.log("루트 요청");
    res.sendFile(__dirname + "/index.html");
});
