let img_1 = document.getElementById("img1");
let img_2 = document.getElementById("img2");
let img_3 = document.getElementById("img3");
let img_4 = document.getElementById("img4");
let img_5 = document.getElementById("img5");
let height = img_1.offsetHeight / 3
let i = 0
function change1() {
    if (i < 2){
        i = i + 1;
        img_1.style.marginTop = `${-height * i}px`;
    } else {
        i = 0
        img_1.style.marginTop = `${-height * i}px`;
    }
}
function change2() {
    if (i < 2){
        i = i + 1;
        img_2.style.marginTop = `${-height * i}px`;
    } else {
        i = 0
        img_2.style.marginTop = `${-height * i}px`;
    }
}
function change3() {
    if (i < 2){
        i = i + 1;
        img_3.style.marginTop = `${-height * i}px`;
    } else {
        i = 0
        img_3.style.marginTop = `${-height * i}px`;
    }
}
function change4() {
    if (i < 2){
        i = i + 1;
        img_4.style.marginTop = `${-height * i}px`;
    } else {
        i = 0
        img_4.style.marginTop = `${-height * i}px`;
    }
}
function change5() {
    if (i < 2){
        i = i + 1;
        img_5.style.marginTop = `${-height * i}px`;
    } else {
        i = 0
        img_5.style.marginTop = `${-height * i}px`;
    }
}
function fit(){
    if (img_1.style.marginTop == img_2.style.marginTop
        && img_1.style.marginTop == img_3.style.marginTop
        && img_1.style.marginTop == img_4.style.marginTop
        && img_1.style.marginTop == img_5.style.marginTop){
        document.getElementById("imgs").style.boxShadow = "#d61b06 15px 15px 15px"
        document.getElementById("msg").innerHTML = "Xuất sắc"
    } else {
        document.getElementById("imgs").style.boxShadow = ""
        document.getElementById("msg").innerHTML = ""
    }
}
setInterval(fit, 0);
