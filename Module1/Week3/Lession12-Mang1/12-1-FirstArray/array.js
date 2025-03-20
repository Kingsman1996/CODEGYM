let chuoi = [];

let input = document.getElementById("msg");

function add() {
    chuoi.push(input.value);
    input.value = "";

}

function show() {
    input.value = `${chuoi}`;
}

function reset() {
    input.value = "";
    chuoi = [];
}