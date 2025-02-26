function tinhdiem(){
    let ly = parseInt(document.getElementById("ly").value)
    let hoa = parseInt(document.getElementById("hoa").value)
    let sinh = parseInt(document.getElementById("sinh").value)
    let tongDiem = ly + hoa + sinh
    document.getElementById("tong").innerHTML = tongDiem
    document.getElementById("dtb").innerHTML = tongDiem/3
}
