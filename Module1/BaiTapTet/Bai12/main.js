const idDiv = document.getElementById("id")
const nameDiv = document.getElementById("name")
const mailDiv = document.getElementById("mail")
const classDiv = document.getElementById("class")
const birthDiv = document.getElementById("birth")
const moduleDiv = document.getElementById("module")
let inputId;
let inputName;
let inputMail;
let inputClass;
let inputBirth;
let inputModule;
const testIds = ["HV-0001", "HV-0002", "HV-0003"]
const testNames = ["Nguyễn Hà Minh Quân", "Lê Sơn Nhất", "Hoàng Mạnh Cường"]
const testClasses = ["C0124G1", "C0224G1", "C0324G1"]
const testMails = ["nhmq@gmail.com", "lsn@gmail.com", "hmc@gmail.com"]
const testBirths = ["18/11/1996", "01/02/1999", "03/04/2005"]
const testModules = [1, 2, 3]
const students = []

class Student {
    constructor(mhv, ten, lop, mail, ngaysinh, module) {
        this.id = mhv
        this.name = ten
        this.class = lop
        this.mail = mail
        this.birth = ngaysinh
        this.module = module
    }
}

for (let i = 0; i < 3; i++) {
    students[i] = new Student(testIds[i], testNames[i], testClasses[i], testMails[i], testBirths[i], testModules[i])
}

function updateDisplay() {
    idDiv.innerHTML = ""
    nameDiv.innerHTML = ""
    classDiv.innerHTML = ""
    mailDiv.innerHTML = ""
    birthDiv.innerHTML = ""
    moduleDiv.innerHTML = ""
    for (let student of students) {
        idDiv.innerHTML += `<div>${student.id}</div>`
        nameDiv.innerHTML += `<div>${student.name}</div>`
        mailDiv.innerHTML += `<div>${student.mail}</div>`
        classDiv.innerHTML += `<div>${student.class}</div>`
        birthDiv.innerHTML += `<div>${student.birth}</div>`
        moduleDiv.innerHTML += `<div>${student.module}</div>`
    }
}

updateDisplay()

function checkId() {
    if (!inputId) {
        return;
    }
    for (let student of students) {
        if (student.id === inputId) {
            inputId = prompt("Mã học viên đã tồn tại, nhập mã khác")
            checkId()
            break
        }
    }
    const reg = /^HV-\d{4}$/
    if (!reg.test(inputId) && inputId) {
        inputId = prompt("Mã học viên không đúng định dạng, mời nhập lại")
        checkId()
    }
}

function checkName() {
    if (!inputName) {
        return
    }
    while (inputName.length > 50 && inputName) {
        inputName = prompt("Tên học viên không quá 50 ký tự, mời nhập lại")
    }
}

function checkBirth() {
    if (!inputBirth) {
        return
    }
    const reg = /^(0[1-9]|[1-2][0-9]|3[0-1])\/(0[1-9]|1[0-2])\/\d{4}$/
    while (!reg.test(inputBirth) && inputBirth) {
        inputBirth = prompt("Ngày sinh không đúng định dạng, nhập lại")
    }
}

function checkModule() {
    if (!inputModule) {
        return;
    }
    const reg = /^[1-6]$/
    while (!reg.test(inputModule)) {
        inputModule = prompt("Chỉ được nhập 1 số từ 1 đến 6")
    }
}

function checkMost() {
    inputId = null
    inputName = null
    inputClass = null
    inputMail = null
    inputBirth = null
    inputModule = null
    inputId = prompt("Nhập mã học viên mới")
    checkId()
    if (inputId) {
        inputName = prompt("Nhập tên học viên mới")
        checkName()
    }
    if (inputName) {
        inputClass = prompt("Nhập tên lớp mới");
    }
    if (inputClass) {
        inputMail = prompt("Nhập email của học viên")
    }
    if (inputMail) {
        inputBirth = prompt("Nhập ngày sinh của học viên")
        checkBirth()
    }
    if (inputBirth) {
        inputModule = prompt("Nhập module học viên đang học")
        checkModule()
    }
}

function addStudent() {
    checkMost()
    if (inputModule) {
        students.push(new Student(inputId, inputName, inputClass, inputMail, inputBirth, parseInt(inputModule)))
        updateDisplay()
    }
}

function fixStudent() {
    const findId = prompt("Nhập mã học viên cần sửa thông tin")
    if (!findId) {
        return;
    }
    for (let student of students) {
        if (findId === student.id) {
            checkMost()
            if (inputModule) {
                student.id = inputId;
                student.name = inputName;
                student.class = inputClass;
                student.mail = inputMail;
                student.birth = inputBirth;
                student.module = inputModule;
                updateDisplay()
            }
            return;
        }
    }
    alert("Mã học viên không tồn tại")
}

function deleteStudent() {
    const findId = prompt("Nhập mã học viên muốn xóa")
    if (!findId) {
        return;
    }
    for (let student of students) {
        if (findId === student.id) {
            if (confirm(`Chắc chắn muốn xóa học viên ${student.name} ?`)) {
                students.splice(students.indexOf(student), 1)
                updateDisplay()
                return;
            }
            return;
        }
    }
    alert("Mã học viên không tồn tại")
}