function cong(){
  let kqcong = parseInt(document.getElementById("1st").value) + parseInt(document.getElementById("2nd").value);
    document.getElementById("ketqua").innerHTML = kqcong
}
function tru(){
    let kqtru = parseInt(document.getElementById("1st").value) - parseInt(document.getElementById("2nd").value);
    document.getElementById("ketqua").innerHTML = kqtru
}
function nhan(){
    let kqnhan = parseInt(document.getElementById("1st").value) * parseInt(document.getElementById("2nd").value);
    document.getElementById("ketqua").innerHTML = kqnhan;
}
function chia(){
    let kqchia = parseInt(document.getElementById("1st").value) / parseInt(document.getElementById("2nd").value);
    document.getElementById("ketqua").innerHTML = kqchia;
}