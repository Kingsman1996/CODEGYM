var nobiTa = document.getElementById("nobita");
var ngang = 0;
var doc = 0;
window.addEventListener("load", ready())

function ready() {
    window.addEventListener("keydown", function (event) {
        var keyPressed = event.keyCode
        switch (keyPressed) {
            case 37:
                leftArrow();
                break;
            case 39:
                rightArrow();
                break;
            case 38:
                upArrow();
                break;
            case 40:
                downArrow();
                break;
        }
    })
}

function leftArrow() {
    ngang = ngang - 10
    nobiTa.style.marginLeft = `${parseInt(ngang)}px`;
}

function rightArrow() {
    ngang = ngang + 10
    nobiTa.style.marginLeft = `${parseInt(ngang)}px`;
}

function upArrow() {
    doc = doc - 10
    nobiTa.style.marginTop = `${parseInt(doc)}px`;
}

function downArrow() {
    doc = doc + 10
    nobiTa.style.marginTop = `${parseInt(doc)}px`;
}



