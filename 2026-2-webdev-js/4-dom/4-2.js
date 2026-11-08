function foodList() {
    let food = document.getElementById("food");
    document.getElementById("view").innerHTML = food.innerHTML;
}

function restList() {
    let rest = document.getElementById("rest");
    document.getElementById("view").innerHTML = rest.innerHTML;
}

document.querySelector("#food").style.backgroundColor = "lightblue";
document.querySelector("#rest").style.backgroundColor = "yellow";
