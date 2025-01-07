
function chuyendoi() {
    let amount = parseInt(document.getElementById('amount').value);
    let fromusd = document.getElementById('fromusd').selected;
    let fromvnd = document.getElementById('fromvnd').selected;
    if (fromusd == true) {
        document.getElementById('tovnd').selected = true;
        document.getElementById("result").innerHTML = amount * 25000;
    } else {
        document.getElementById('tousd').selected = true;
        document.getElementById("result").innerHTML = amount / 25000 ;
    }
}