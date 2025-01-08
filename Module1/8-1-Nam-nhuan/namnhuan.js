function check(){
    let year = parseInt(document.getElementById('year').value);
    if(year % 4 == 0){
        if (year % 100 == 0 && year % 400 !== 0 ){
            document.getElementById("ketqua").innerHTML = "Đây không là năm nhuận"
        } else {
            document.getElementById("ketqua").innerHTML = "Đây là năm nhuận"
        }
    } else {
        document.getElementById("ketqua").innerHTML = "Đây không là năm nhuận"
    }
}