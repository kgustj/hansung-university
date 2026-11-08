const tags = document.body.querySelectorAll(".hTag");

// 1-1;
// for (let i = 0; i < tags.length; i++) {
//     let newDiv = document.createElement("div");
//     document.body.appendChild(newDiv);
//     newDiv.setAttribute("id", `text${i + 1}`);
//     newDiv.innerHTML = tags[i].innerHTML;
// }

// 1-2;
// for (let i = 0; i < tags.length; i++) {
//     let newDiv = document.createElement(`h${i + 1}`);
//     document.body.appendChild(newDiv);
//     newDiv.setAttribute("id", `text${i + 1}`);
//     newDiv.innerHTML = tags[i].innerHTML;
// }

// 1-3;
// for (let i = tags.length - 1; i >= 0; i--) {
//     let newDiv = document.createElement(`h${i + 1}`);
//     document.body.appendChild(newDiv);
//     newDiv.setAttribute("id", `text${i + 1}`);
//     newDiv.innerHTML = tags[i].innerHTML;
// }

// 1-4
for (let i = tags.length - 1; i >= 0; i--) {
    tags[i].style.color = "blue";

    let newDiv = document.createElement(`h${i + 1}`);
    document.body.appendChild(newDiv);
    newDiv.setAttribute("id", `text${i + 1}`);
    newDiv.innerHTML = tags[i].innerHTML;
    if (i % 2 == 0) {
        newDiv.style.color = "red";
    }
}
