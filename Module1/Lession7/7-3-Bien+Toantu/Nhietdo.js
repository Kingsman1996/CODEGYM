function chuyen(){
    let doC = parseInt(document.getElementById("doC").value) ;
    let doF = doC*9/5 + 32;
    document.getElementById("doF").innerHTML = " " + doF;
}