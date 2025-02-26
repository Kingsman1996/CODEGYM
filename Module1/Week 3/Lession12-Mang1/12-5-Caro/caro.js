let array = [];
let span = "<span>0</span>"
let rowInput, colInput, value
for (i = 0; i < 5; i++) {
    array.push([])
    for (j = 0; j < 5; j++) {
        array[i][j] = span;
    }
}

function drawCaro() {
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            document.getElementById("caro").innerHTML += array[i][j];
        }
        document.getElementById("caro").innerHTML += "<br>"
    }
}

function changeValue() {
    rowInput = parseInt(prompt("Enter row")) - 1;
    colInput = parseInt(prompt("Enter column ")) - 1;
    value = prompt("Enter new value");
    document.getElementById("caro").innerHTML = ""
    array[rowInput][colInput] = `<span>${value}</span>`;
    drawCaro()
}
