let x = 0;

function bgColor() {
    if (x == 0) {
        document.body.style.backgroundColor = "white";
    } else if (x % 2 == 1) {
        document.body.style.backgroundColor = "yellow";
    } else {
        document.body.style.backgroundColor = "lightgreen";
    }
}

function xCount() {
    x++;
    document.getElementById("number").innerHTML = x;
    bgColor();
}

function xReset() {
    x = 0;
    document.getElementById("number").innerHTML = x;
    bgColor();
}

function for1() {
    for (let i = 0; i < 5; i++) {
        document.writeln(i);
    }
}

function for2() {
    const star = "☆";
    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            document.write(star);
        }
        document.write("<br>");
    }
}

function for3() {
    for (let i = 0; i < 5; i++) {
        for (let j = 5; i < j; j--) {
            document.write("@");
        }
        document.write("<br>");
    }
}

function pr() {
    const heart = "♡";
    for (let i = 1; i <= 5; i++) {
        for (let j = 0; j < i; j++) {
            document.write(heart);
        }
        document.write("<br>");
    }
}

function add1() {
    let a, b, sum;
    a = Number(document.getElementById("txt11").value);
    b = Number(document.getElementById("txt12").value);

    sum = a + b;

    document.getElementById("total1").innerHTML = sum;
}

function add2() {
    let a, b, sum, result;
    a = Number(document.getElementById("txt21").value);
    b = Number(document.getElementById("txt22").value);

    sum = a + b;
    result = a + "+" + b + "=" + sum;

    document.getElementById("txt21").value = "";
    document.getElementById("txt22").value = "";

    document.getElementById("total2").innerHTML = result;
}
