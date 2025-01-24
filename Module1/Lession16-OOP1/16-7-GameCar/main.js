const canvas = document.getElementById("canvas")
const ctx = canvas.getContext("2d")
canvas.width = window.innerWidth / 2
canvas.height = window.innerHeight - 50

class VatThe {
    constructor(left, top, rong, cao) {
        this.x = left
        this.y = top
        this.rong = rong
        this.cao = cao
    }

    draw(which) {
        ctx.drawImage(which, this.x, this.y, this.rong, this.cao);
    }
}

const car = new VatThe(canvas.width / 2 - 50, canvas.height - 100, 100, 100)
const carImg = new Image()
carImg.src = "ferrari.jpg"
carImg.onload = () => {
    car.draw(carImg)
}

const rockImg = new Image()
rockImg.src = "rock.jpg"
rockImg.onload = () => {
    for (let item of rocks) {
        item.draw(rockImg)
    }
}
const giftImg = new Image()
giftImg.src = "gift.jpg"
giftImg.onload = () => {
    for (let item of gifts) {
        item.draw(giftImg)
    }
}
let speed = 0.1
let gameRunning = true

function changeDirectCar() {
    document.addEventListener("keydown", (ev) => {
        switch (ev.key) {
            case "ArrowUp":
                car.y -= speed + 10
                break;
            case "ArrowDown":
                car.y += speed + 10
                break;
            case "ArrowLeft":
                car.x -= speed + 10
                break;
            case "ArrowRight":
                car.x += speed + 10
                break
            case "Control":
                speed += 0.1
        }
        update()
    })
}


function autoMoveCar() {
    if (!gameRunning) {
        return;
    }
    car.y -= speed
    if (car.x + car.rong > canvas.width) {
        car.x = canvas.width - car.rong
    }
    if (car.x < 0) {
        car.x = 0
    }
    update()
    crash()
    requestAnimationFrame(autoMoveCar)
}


function update() {
    ctx.clearRect(0, 0, canvas.width, canvas.height)
    car.draw(carImg)
    for (let item of gifts) {
        item.draw(giftImg)
    }
    for (let item of rocks) {
        item.draw(rockImg)
    }
    ctx.font = "20px Arial";
    ctx.fillStyle = "black";
    ctx.fillText(`Điểm số: ${score}`, 10, 30)
    requestAnimationFrame(update)
}

function crash() {
    if (car.y < rock.y + rock.cao) {
        if (car.x + car.rong > rock.x && rock.x + rock.rong > car.x + car.rong
            || rock.x < car.x && car.x < rock.x + rock.rong) {
            newGame()
        }
    }
    if (
        car.y < gift.y + gift.cao &&
        car.y + car.cao > gift.y &&
        car.x + car.rong > gift.x &&
        car.x < gift.x + gift.rong
    ) {
        score += 10;
        gift.x = Math.random() * (canvas.width - gift.rong);
        gift.y = Math.random() * (canvas.height / 2);
    }
}

function newGame() {
    gameRunning = false
    if (confirm("Bạn muốn bắt trò chơi mới ?")) {
        car.x = canvas.width / 2 - 50
        car.y = canvas.height - 100
        gameRunning = true
        score = 0
        ctx.clearRect(0, 0, canvas.width, canvas.height)
        for (let item of rocks) {
            item.draw(rockImg)
        }
        for (let item of gifts) {
            item.draw(giftImg)
        }
        autoMoveCar()
    } else {
        ctx.clearRect(0, 0, canvas.width, canvas.height)
        car.x = canvas.width / 2 - 50
        car.y = canvas.height - 100
        car.draw(carImg)
        for (let item of rocks) {
            item.draw(rockImg)
        }
        for (let item of gifts) {
            item.draw(giftImg)
        }
        for (let item of gifts) {
            item.draw(giftImg)
        }
    }
}

let score = 0
document.getElementById("start").addEventListener("click", changeDirectCar)

const rocks = [];
const gifts = [];
for (let i = 0; i < 3; i++) {
    rocks.push(new VatThe(Math.random() * 0.9 * canvas.width, Math.random() * canvas.height / 3, 30, 30))
    gifts.push(new VatThe(Math.random() * 0.9 * canvas.width, Math.random() * canvas.height / 3, 30, 30))
}
console.log(gifts)
