let manHinh = document.getElementById("screen")
manHinh.innerHTML = ""

function number(num) {
    manHinh.innerHTML += num;
}

function opera(ope) {
    let lastOpe = manHinh.innerHTML.slice(manHinh.innerHTML.length - 1)
    if (lastOpe !== "+" && lastOpe !== "-" && lastOpe !== "*" && lastOpe !== "/") {
        manHinh.innerHTML += ope;
    }
}

function equal() {
    manHinh.innerHTML = eval(manHinh.innerHTML);
}

function reset() {
    manHinh.innerHTML = ""
}












