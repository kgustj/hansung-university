let cnt = 0;

function createDiv() {
    let parent = document.getElementById("parent");
    let newDiv = document.createElement("div");
    let cntDiv = document.createElement("div");

    newDiv.innerHTML = "<p>새로 생성된 DIV입니다.</p>";
    newDiv.setAttribute("id", "myDiv");
    newDiv.style.backgroundColor = "yellow";
    parent.appendChild(newDiv);

    cnt++;
    cntDiv.innerHTML = `cnt = ${cnt}`;
    cntDiv.setAttribute("id", "cntDiv");
    parent.appendChild(cntDiv);

    newDiv.onclick = function () {
        cnt--;
        let p = this.parentElement; // 부모 HTML 태그 요소
        p.removeChild(this); // 자신을 부모로부터 제거
    };
}

function removeDiv() {
    const divs = document.body.querySelectorAll("#myDiv");
    const cnts = document.body.querySelectorAll("#cntDiv");

    cnt = 0;
    for (let i = 0; i < divs.length; i++) {
        document.body.removeChild(divs[i]);
    }
    for (let i = 0; i < cnts.length; i++) {
        document.body.removeChild(cnts[i]);
    }
}
