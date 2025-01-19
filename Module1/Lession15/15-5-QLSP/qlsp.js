const edit = "<button onclick=\"editProduct(this)\">Sửa</button>"
const del = "<button onclick=\"deleteProduct(this)\">Xóa</button>"
const productsDiv = document.getElementById("products")
const amountDiv = document.getElementById("amount")
let products = ["Sony", "Nokia", "Samsung"]

function displayProducts() {
    for (let i = 0; i < products.length; i++) {
        productsDiv.innerHTML += `<span>${products[i]}</span>${edit}${del}<br>`
    }
    amountDiv.innerHTML = `${products.length} sản phẩm`
}

function addProduct() {
    const productName = prompt("Nhập tên sản phẩm")
    products.push(productName)
    productsDiv.innerHTML = ""
    displayProducts()
    amountDiv.innerHTML = `${products.length} sản phẩm`
}

function editProduct(clicked) {
    const newName = prompt("Nhập tên mới của sản phẩm")
    const index = products.indexOf(clicked.previousElementSibling.innerHTML);
    clicked.previousElementSibling.innerHTML = `${newName}`
    products.splice(index, 1, `${newName}`);
}

function deleteProduct(clicked) {
    const yes = confirm(`Bạn chắc chắn muốn xóa sản phẩm
        ${clicked.previousElementSibling.previousElementSibling.innerHTML} ?`)
    if (yes) {
        const index = products.indexOf(clicked.previousElementSibling.previousElementSibling.innerHTML);
        products.splice(index, 1);
        productsDiv.innerHTML = ""
        displayProducts()
        amountDiv.innerHTML = `${products.length} sản phẩm`
    }
}