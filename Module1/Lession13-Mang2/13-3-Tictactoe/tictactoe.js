let array = [];
let swap;
let span = "<span>()</span>"
let rowInput, colInput;
let i, j;
for (i = 0; i < 5; i++) {
    array.push([])
    for (j = 0; j < 5; j++) {
        array[i][j] = span;
    }
}
const cleanCaro = array

function draw(which) {
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            document.getElementById("caro").innerHTML += which[i][j];
        }
        document.getElementById("caro").innerHTML += "<br>"
    }
}

function win() {
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            if ((array[i][j] === `<span>x</span>` &&
                    array[i][j + 1] === `<span>x</span>` &&
                    array[i][j + 2] === `<span>x</span>`) ||
                (array[i][j] === `<span>x</span>` &&
                    array[i + 1][j] === `<span>x</span>` &&
                    array[i + 2][j] === `<span>x</span>`) ||
                (array[i][j] === `<span>x</span>` &&
                    array[i + 1][j + 1] === `<span>x</span>` &&
                    array[i + 2][j + 2] === `<span>x</span>`)
            ) {
                alert("End game")
                break;
            }
        }
    }
}

function changeValue() {
    rowInput = parseInt(prompt("Enter row")) - 1;
    colInput = parseInt(prompt("Enter column ")) - 1;
    document.getElementById("caro").innerHTML = ""
    if (swap === `<span>x</span>`) {
        array[rowInput][colInput] = `<span>x</span>`;
        swap = "<span>0</span>"
    } else {
        array[rowInput][colInput] = `<span>0</span>`;
        swap = `<span>x</span>`;
    }
    draw(array);
    win()
}







