function ketqua(){
    let r = parseInt(document.getElementById("bankinh").value);
    let chuvi = 2*r*Math.PI
    let dientich = Math.PI * Math.pow(r,2)
    document.getElementById("chuvi").innerHTML = chuvi;
    document.getElementById("dientich").innerHTML = dientich;

}