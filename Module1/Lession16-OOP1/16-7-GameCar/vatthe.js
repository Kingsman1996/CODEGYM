const canvas = document.getElementById("canvas")
const ctx = canvas.getContext("2d")
canvas.width = window.innerWidth / 3
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

class Car extends VatThe {
    constructor(left, top, rong, cao, v) {
        super(left, top, rong, cao);
        this.v = v
    }

    manualMove() {
        document.addEventListener("keydown", (ev) => {
            switch (ev.key) {
                case "ArrowUp":
                    this.y -= this.v
                    break;
                case "ArrowDown":
                    this.y += this.v
                    break;
                case "ArrowLeft":
                    this.x -= this.v
                    break;
                case "ArrowRight":
                    this.x += this.v
                    break
                case "Control":
                    this.v += 5
            }
            this.redraw()
        })
    }
    redraw() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);  // Xóa toàn bộ canvas trước khi vẽ lại
        vatcan1.draw(vatcan1Img);  // Vẽ vật cản
        this.draw(carImg);  // Vẽ lại xe

    }
    // crashCheck() {
    //     if (this.x)
    // }
}


const carImg = new Image()
carImg.src = "./imgs/ferrari-laferrari-top-view-design-800x450-1.jpg"
const vatcan1Img = new Image()
vatcan1Img.src = "./imgs/rock.jfif.png"

const car = new Car(canvas.width / 2 - 50, canvas.height - 100, 100, 100, 20)
carImg.onload = () => {
    car.draw(carImg)
    car.manualMove()
}
const vatcan1 = new VatThe(100, 100, 100, 100)
vatcan1Img.onload = () => {
    vatcan1.draw(vatcan1Img)
}
