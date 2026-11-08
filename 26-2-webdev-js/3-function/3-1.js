function dClock() {
    const dt = new Date();
    const hours = dt.getHours();
    const minutes = dt.getMinutes();
    const seconds = dt.getSeconds();

    document.getElementById("show").innerHTML = hours + ":" + minutes + ":" + seconds;
}
setInterval(dClock, 100);

function isOpen() {
    const dt = new Date();
    const hours = dt.getHours();
    // const hours = 21;

    if (9 <= hours && hours < 21) {
        document.getElementById("open").innerHTML = "영업 중";
        document.body.style.backgroundColor = "white";
    } else {
        document.getElementById("open").innerHTML = "영업 종료";
        document.body.style.backgroundColor = "black";
        document.body.style.color = "white";
    }
}
setInterval(isOpen, 100);
