function check() {
    var month = parseInt(document.getElementById('month').value);
    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            document.getElementById('msg').innerHTML = "Tháng này có 31 ngày";
            document.getElementById('msg').style.color = "blue";
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            document.getElementById('msg').innerHTML = "Tháng này có 30 ngày";
            document.getElementById('msg').style.color = "black";
            break;
        case 2:
            document.getElementById('msg').innerHTML = "Tháng này có 28 hoặc 29 ngày";
            document.getElementById('msg').style.color = "green";
            break;
        default:
            document.getElementById('msg').innerHTML = "Không có tháng này";
            document.getElementById('msg').style.color = "red";
    }
}